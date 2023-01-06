package com.lianchuangjie.lianchuangjie.service.Home.impl;

import com.lianchuangjie.lianchuangjie.mapper.Home.HomeChartMapper;
import com.lianchuangjie.lianchuangjie.service.Home.HomeChartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class HomeChartServiceImpl implements HomeChartService {
    @Resource
    HomeChartMapper homeChartMapper;
    @Override
    public List<Map<String, String>> getSalesRankService() {
        return homeChartMapper.querySalesRank();
    }

    @Override
    public List<Map<String, String>> getMonthSalesService() {
        return homeChartMapper.queryMonthSales();
    }

    @Override
    public List<Map<String, String>> getYearSalesService() {
        return homeChartMapper.getYearSales();
    }
}
