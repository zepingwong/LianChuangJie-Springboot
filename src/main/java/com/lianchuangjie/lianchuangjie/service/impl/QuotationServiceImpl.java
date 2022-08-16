package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuotationServiceImpl extends ServiceImpl<QuotationMapper, QuotationEntity> implements QuotationService {
    @Resource
    QuotationMapper quotationMapper;
    @Override
    public Page<QuotationVO> list(QuotationSearchDTO searchCondition) {
        Page<QuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        QueryWrapper<QuotationVO> queryWrapper = new QueryWrapper<>();
        String enquirySubTable = SqlHelper.table(EnquirySubEntity.class).getTableName();
        String enquiryMainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        if (searchCondition.getModle() != null) {
            queryWrapper.like(enquirySubTable + ".Modle", searchCondition.getModle());
        }
        if (searchCondition.getBrand() != null) {
            queryWrapper.eq(enquirySubTable+ ".Brand", searchCondition.getBrand());
        }
        if (searchCondition.getUStatus() != null) {
            queryWrapper.eq("fp.U_Status", searchCondition.getUStatus());
        }
        if (searchCondition.getOwnerCode() != null) {
            queryWrapper.eq(enquiryMainTable + ".OwnerCode", searchCondition.getOwnerCode());
        }
        if (searchCondition.getInquiryDateStart() != null) {
            queryWrapper.ge("T_ICIN.CreateDate", searchCondition.getInquiryDateStart());
        }
        if (searchCondition.getInquiryDateEnd() != null) {
            queryWrapper.le("T_ICIN.CreateDate", searchCondition.getInquiryDateEnd());
        }
        page.addOrder(OrderItem.desc(enquiryMainTable + ".CreateDate"));
        quotationMapper.selectList(page, queryWrapper, searchCondition.getUBuyer());
        return page;
    }

    @Override
    public QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper) {
        return quotationMapper.selectOne(queryWrapper);
    }
}
