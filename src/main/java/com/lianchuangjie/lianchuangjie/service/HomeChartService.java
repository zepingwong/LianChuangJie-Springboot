package com.lianchuangjie.lianchuangjie.service;

import java.util.List;
import java.util.Map;

public interface HomeChartService {
    /**
     * @description 销售排名
     * @return List
     */

    List<Map<String, String>> getSalesRankService();

    /**
     * @description 月销售额
     * @return List
     */
    List<Map<String, String>> getMonthSalesService();

    /**
     * @description 年销售额
     * @return List
     */
    List<Map<String, String>> getYearSalesService();
}
