package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabPurchaseOrderMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabPurchaseOrderService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPricePurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankPurchaseOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabPurchaseOrderServiceImpl extends ServiceImpl<TabPurchaseOrderMapper, PurchaseOrderSubEntity> implements TabPurchaseOrderService {
    @Resource
    TabPurchaseOrderMapper tabPurchaseOrderMapper;

    @Override
    public Page<TabQuotationPurchaseOrderVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setRecords(tabPurchaseOrderMapper.selectQuotationTabList(searchCondition));
        page.setTotal(tabPurchaseOrderMapper.countQuotationTabList(searchCondition));
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        return page;
    }

    @Override
    public Page<TabStockPricePurchaseOrderVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPricePurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setRecords(tabPurchaseOrderMapper.selectStockPriceTabList(searchCondition));
        page.setTotal(tabPurchaseOrderMapper.countQuotationTabList(searchCondition));
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        return page;
    }

    @Override
    public Page<TabStockRankPurchaseOrderVO> stockRankTabList(TabSearchDTO searchCondition) {
        Page<TabStockRankPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setRecords(tabPurchaseOrderMapper.selectStockRankTabList(searchCondition));
        page.setTotal(tabPurchaseOrderMapper.countQuotationTabList(searchCondition));
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        return page;
    }

    @Override
    public Page<TabEnquiryPurchaseOrderVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        tabPurchaseOrderMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabSearchPurchaseOrderVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        tabPurchaseOrderMapper.selectSearchTabList(page, searchCondition);
        return page;
    }
}
