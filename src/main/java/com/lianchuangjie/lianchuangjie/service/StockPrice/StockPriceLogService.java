package com.lianchuangjie.lianchuangjie.service.StockPrice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceLogVO;

public interface StockPriceLogService extends IService<StockPriceLogEntity> {
    Page<StockPriceLogVO> list(StockPriceLogSearchDTO stockPriceSearchDTO);
}
