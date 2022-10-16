package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;

public interface StockService {
    Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
    Page<TabQuotationStockVO> quotationTabList(TabSearchDTO tabSearchDTO);
}
