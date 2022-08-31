package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;

public interface StockPriceService extends IService<StockPriceEntity> {
    Page<StockPriceVO> list(StockPriceSearchDTO stockPriceSearchDTO);
}
