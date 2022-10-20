package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.dto.QuotationReplyDTO;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.vo.Quotation.QuotationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuotationServiceImpl extends ServiceImpl<QuotationMapper, QuotationEntity> implements QuotationService {
    @Resource
    QuotationMapper quotationMapper;
    @Resource
    EnquiryMainMapper enquiryMainMapper;

    @Override
    public Page<QuotationVO> getList(QuotationSearchDTO searchCondition) {
        Page<QuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        String enquiryMainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        page.addOrder(OrderItem.desc(enquiryMainTable + ".CreateDate"));
        quotationMapper.selectList(page, searchCondition);
        return page;
    }
    @Override
    public Boolean reply(QuotationReplyDTO quotationReplyDTO) {
        /*
         * 1. 修改采购报价单状态
         * 2. 如果是采购自己保存的报价信息则 T_ICIN1.Status 由 "N" 修改为 "Y"
         * 3. 如果是需要采购确认的，采购直接确认时 T_ICIN1.Status 由 "W" 修改为 "C"
         * 4. 若采购修改了报价信息，则 T_ICIN1.Status 由 "W" 修改为 "U"
         */
        QueryWrapper<QuotationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DocEntry", quotationReplyDTO.getDocEntry());
        queryWrapper.eq("LineNum", quotationReplyDTO.getLineNum());
        QuotationEntity quotationEntity = quotationMapper.selectOne(queryWrapper);
        if (quotationEntity.getUStatus() != null & quotationEntity.getUStatus().equals("N")) {
            quotationEntity.setUStatus("Y");
        } else if (quotationEntity.getUStatus() != null & quotationEntity.getUStatus().equals("W")) {
            quotationEntity.setUStatus("C");
        }
        quotationMapper.update(quotationEntity, queryWrapper);
        /*
         * 1. 更新询价单主表状态为有更新 T_ICIN.New = 'Y'
         */
        QueryWrapper<EnquiryMainEntity> selectEnquiryMainEntity = new QueryWrapper<>();
        selectEnquiryMainEntity.eq("DocEntry", quotationReplyDTO.getDocEntry());
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(quotationReplyDTO.getDocEntry(), quotationReplyDTO.getOwnerCode());
        enquiryMainEntity.setUNew("Y");
        return enquiryMainMapper.update(enquiryMainEntity, selectEnquiryMainEntity) == 1;
    }

    @Override
    public QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper) {
        return quotationMapper.selectOne(queryWrapper);
    }
}
