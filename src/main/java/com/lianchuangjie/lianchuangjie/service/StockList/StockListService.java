package com.lianchuangjie.lianchuangjie.service.StockList;

import java.math.BigDecimal;
import java.util.List;

public interface StockListService {
    /**
     * @param modle modle
     * @return List
     * @description 获取某型号采购成本价格走势
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<BigDecimal> purchasePriceList(String modle);
}
