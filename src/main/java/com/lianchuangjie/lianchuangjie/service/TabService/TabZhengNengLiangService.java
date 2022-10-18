package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;

public interface TabZhengNengLiangService extends IService<ZhengNengLiangSubEntity> {
    Page<TabStockPriceZNLVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
