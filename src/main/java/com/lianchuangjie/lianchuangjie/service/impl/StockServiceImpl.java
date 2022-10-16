package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.mapper.StockMapper;
import com.lianchuangjie.lianchuangjie.service.StockService;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper stockMapper;
    @Override
    public Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceOriginVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        // 设置分页查询结果
        page.setRecords(stockMapper.selectStockPriceTabList(searchCondition));
        page.setTotal(stockMapper.countStockPriceTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabQuotationStockVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationStockVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        stockMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }
}
