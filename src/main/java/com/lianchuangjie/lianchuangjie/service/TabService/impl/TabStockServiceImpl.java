package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabStockMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabStockService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryStockVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabStockServiceImpl extends ServiceImpl<TabStockMapper, StockQuantityEntity> implements TabStockService {
    @Resource
    TabStockMapper tabStockMapper;


    @Override
    public Page<TabEnquiryStockVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryStockVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_OBTN.InDate"));
        tabStockMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceOriginVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        // 设置分页查询结果
        page.setRecords(tabStockMapper.selectStockPriceTabList(searchCondition));
        page.setTotal(tabStockMapper.countStockPriceTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabQuotationStockVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationStockVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        tabStockMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }
}
