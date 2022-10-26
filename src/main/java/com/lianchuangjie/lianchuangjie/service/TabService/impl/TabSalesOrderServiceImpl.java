package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabSalesOrderMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabSalesOrderService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSalesOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabSalesOrderServiceImpl extends ServiceImpl<TabSalesOrderMapper, SalesOrderSubEntity> implements TabSalesOrderService {
    @Resource
    TabSalesOrderMapper tabSalesOrderMapper;

    public Page<TabQuotationSalesOrderVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        tabSalesOrderMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabStockPriceSalesOrderVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        tabSalesOrderMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabEnquirySalesOrderVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquirySalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        page.setRecords(tabSalesOrderMapper.selectEnquiryTabList(searchCondition));
        page.setTotal(tabSalesOrderMapper.countEnquiryTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabSearchSalesOrderVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ORDR.DocDate"));
        page.setRecords(tabSalesOrderMapper.selectSearchTabList(searchCondition));
        page.setTotal(tabSalesOrderMapper.countEnquiryTabList(searchCondition));
        return page;
    }
}
