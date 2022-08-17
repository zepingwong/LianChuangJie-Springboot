package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.TabStockVO;

public interface StockQuantityService extends IService<StockQuantityEntity> {
    Page<TabStockVO> tabList(TabSearchDTO tabSearchDTO);
}
