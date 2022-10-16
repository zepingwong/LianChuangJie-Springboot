package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;

public interface ZhengNengLiangSubService extends IService<ZhengNengLiangSubEntity> {
    Page<TabStockPriceZNLVO> tabList(TabSearchDTO tabSearchDTO);
}
