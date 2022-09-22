package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.EnquiryReQuoteService;
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
        // 该条客户需求
        EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(enquiryReQuoteDTO.getDocEntry(), enquiryReQuoteDTO.getLineNum());
        // 该需求主表
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(enquiryReQuoteDTO.getDocEntry(), SessionUtil.getUserSign());
        // 销售员
        QueryWrapper<UserEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("UserSign", SessionUtil.getUserSign());
        UserEntity userEntity = userMapper.getOne(queryWrapper1);
        // 将采购的编号加进去
        String buyers = enquirySubEntity.getBuyers();
        if (!buyers.contains(String.valueOf(enquiryReQuoteDTO.getUBuyer()))) {
            buyers = buyers + "," + enquiryReQuoteDTO.getUBuyer();
        }
        enquirySubEntity.setBuyers(buyers);
        enquirySubMapper.updateBuyers(enquirySubEntity);
        // 采购报价表直接保存此条报价信息
        QueryWrapper<QuotationEntity> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("DocEntry", enquiryReQuoteDTO.getBaseEntry());
        queryWrapper2.eq("LineNum", enquiryReQuoteDTO.getBaseLine());
        QuotationEntity quotationEntity = quotationMapper.selectOne(queryWrapper2);
        quotationEntity.setDocEntry(enquiryReQuoteDTO.getDocEntry());
        Long lineNum = quotationMapper.count(enquiryReQuoteDTO.getDocEntry()) + 1;
        quotationEntity.setLineNum(lineNum);
        quotationEntity.setDocEntry(enquiryReQuoteDTO.getDocEntry());
        quotationEntity.setUBaseEntry(enquiryReQuoteDTO.getDocEntry()); // T_ICIN1.U_BaseEntry
        quotationEntity.setUBaseLine(enquiryReQuoteDTO.getLineNum()); // T_ICIN1.U_BaseLine
        quotationEntity.setUStatus("U");
        // 需求信息
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
        quotationMapper.insert(quotationEntity);
        return true;
    }
}
