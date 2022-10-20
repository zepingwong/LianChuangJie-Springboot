package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryReQuoteService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryReQuoteServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquiryReQuoteService {
    @Resource
    QuotationMapper quotationMapper;
    @Resource
    EnquirySubMapper enquirySubMapper;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public Boolean handle(EnquiryReQuoteDTO enquiryReQuoteDTO) {
        // 查询客户需求
        QueryWrapper<EnquirySubEntity> selectEnquirySubEntity = new QueryWrapper<>();
        selectEnquirySubEntity.eq("DocEntry", enquiryReQuoteDTO.getDocEntry());
        selectEnquirySubEntity.eq("LineNum", enquiryReQuoteDTO.getLineNum());
        EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(selectEnquirySubEntity);
        // 需求主表
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(enquiryReQuoteDTO.getDocEntry(), SessionUtil.getUser().getUserSign());
        // 该货源的采购员
        QueryWrapper<UserEntity> selectUserEntity = new QueryWrapper<>();
        selectUserEntity.eq("UserSign", SessionUtil.getUser().getUserSign());
        UserEntity userEntity = userMapper.selectOne(selectUserEntity);
        /*
         * 1. 判断当前询价单是否已经发送给该货源对应的采购
         * 2. 更新 U_ICIN1.Buyers
         */
        String buyer = enquirySubEntity.getBuyer();
        if (!buyer.contains(String.valueOf(enquiryReQuoteDTO.getUBuyer()))) {
            buyer = buyer + "," + enquiryReQuoteDTO.getUBuyer();
        }
        enquirySubEntity.setBuyer(buyer);
        enquirySubMapper.updateBuyers(enquirySubEntity);
        /*
         * 1. 采购报价表 T_ICIN1 直接保存这条待确认的报价信息
         * 2. T_ICIN1.Status = 'W'
         * 3. 更新货源的需求信息为当前客户需求
         */
        Long docEntry = enquiryReQuoteDTO.getDocEntry(); // 询价单单据编号
        Long lineNum = quotationMapper.count(docEntry) + 1; // 采购报价单行号
        QueryWrapper<QuotationEntity> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("DocEntry", enquiryReQuoteDTO.getBaseEntry()); // 采购报价单单据编号
        queryWrapper2.eq("LineNum", enquiryReQuoteDTO.getBaseLine()); // 采购报价单单据行号
        QuotationEntity quotationEntity = quotationMapper.selectOne(queryWrapper2); // 货源
        quotationEntity.setDocEntry(docEntry); // 更新货源询价单单据编号
        quotationEntity.setLineNum(lineNum); // 更新货源询价单单据行号
        quotationEntity.setUBaseEntry(enquirySubEntity.getDocEntry()); // T_ICIN1.U_BaseEntry = U_ICIN1.DocEntry
        quotationEntity.setUBaseLine(enquirySubEntity.getLineNum()); // T_ICIN1.U_BaseLine = U_ICIN1.LineNum
        quotationEntity.setBrand(enquirySubEntity.getBrand()); // 需求品牌
        quotationEntity.setModle(enquirySubEntity.getModle()); // 需求型号
        quotationEntity.setYear(enquirySubEntity.getYear()); // 批次
        quotationEntity.setDemandDate(enquiryMainEntity.getCreateDate()); // 询价日期
        quotationEntity.setUDelivery(enquirySubEntity.getDelivery()); // 需求交期
        quotationEntity.setUEccn(enquirySubEntity.getEccn()); // ECCN
        quotationEntity.setUSecrecy(enquirySubEntity.getSecrecy()); // 是否保密
        quotationEntity.setUStatus(enquirySubEntity.getStatus()); // 询价状态
        quotationEntity.setUPrePrice(enquirySubEntity.getPrePrice()); // 参考价格
        quotationEntity.setUPreTotal(enquirySubEntity.getPrePrice().multiply(enquirySubEntity.getDemandQty())); // 预估总价
        quotationEntity.setExpectedPrice(enquirySubEntity.getExpectedPrice()); // 期待价格
        quotationEntity.setLineInquiryStatus(1);
        quotationEntity.setUDeptCod(userEntity.getDftDeptName()); // 询价部门名称
        quotationEntity.setUGroupCode(enquiryMainEntity.getUCusGroupCode()); // 客户性质名称
        quotationEntity.setCusLevel(enquiryMainEntity.getUCusLevel()); // 客户等级
        quotationEntity.setUCurrency(enquirySubEntity.getCurrency()); // 销项货币
        quotationEntity.setUVatGroup(enquirySubEntity.getVatGroup()); // 销项税率代码
        quotationEntity.setUKeyPoint("Y"); // 重点询价标识
        quotationEntity.setUKeyRemark("销售确认货源");
        quotationEntity.setUCardCode(enquiryMainEntity.getCardCode()); // 客户代码
        quotationEntity.setCardName(enquiryMainEntity.getCardName()); // 客户名称
        quotationEntity.setUKeyUser(userEntity.getUserSign()); // 谁标记的重要询价
        // 销售向采购发送确认货源请求时的原货源索引
        quotationEntity.setUOriginEntry(enquiryReQuoteDTO.getBaseEntry());
        quotationEntity.setUOriginLine(enquiryReQuoteDTO.getBaseLine());
        quotationEntity.setUStatus("W");
        return quotationMapper.insert(quotationEntity) == 1;
    }
}
