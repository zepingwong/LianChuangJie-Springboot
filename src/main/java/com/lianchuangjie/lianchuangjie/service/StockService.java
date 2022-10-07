package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceOriginVO;

public interface StockService {
    Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
