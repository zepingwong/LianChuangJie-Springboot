package com.lianchuangjie.lianchuangjie.service.StockPrice;

import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;

import java.util.List;

public interface StockPriceAlgorithmService {
    Boolean calculateOneDayService(String triggerType);
    Boolean calculateADayService(List<StockPriceVO> list);
}
