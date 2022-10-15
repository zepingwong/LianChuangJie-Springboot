package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.SalesOrderSubMapper;
import com.lianchuangjie.lianchuangjie.service.SalesOrderSubService;
import com.lianchuangjie.lianchuangjie.vo.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabSearchSalesOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesOrderSubServiceImpl extends ServiceImpl<SalesOrderSubMapper, SalesOrderSubEntity> implements SalesOrderSubService {
    @Resource
    SalesOrderSubMapper salesOrderSubMapper;

    public Page<TabQuotationSalesOrderVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        salesOrderSubMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabEnquirySalesOrderVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquirySalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        page.setRecords(salesOrderSubMapper.selectEnquiryTabList(searchCondition));
        page.setTotal(salesOrderSubMapper.countEnquiryTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabSearchSalesOrderVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        page.setRecords(salesOrderSubMapper.selectSearchTabList(searchCondition));
        page.setTotal(salesOrderSubMapper.countEnquiryTabList(searchCondition));
        return page;
    }
}
