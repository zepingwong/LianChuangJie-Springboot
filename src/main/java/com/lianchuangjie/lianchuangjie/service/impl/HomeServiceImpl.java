package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.HomeMapper;
import com.lianchuangjie.lianchuangjie.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    HomeMapper homeMapper;
    @Override
    public List<Map<String, String>> getSalesRankService() {
        return homeMapper.querySalesRank();
    }

    @Override
    public List<Map<String, String>> getMonthSalesService() {
        return homeMapper.queryMonthSales();
    }

    @Override
    public List<Map<String, String>> getYearSalesService() {
        return homeMapper.getYearSales();
    }
}
