package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.HomeChartService;
import com.lianchuangjie.lianchuangjie.service.HomeToDoService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeToDoService homeToDoService;
    @Resource
    HomeChartService homeChartService;

    @GetMapping("/todo")
    @Authentication(buyer = true, sale = true)
    public Result<Map<String, Long>> todoController() {
        Map<String, Long> query = homeToDoService.getTodoNum(SessionUtil.getUserSign());
        return Result.success(query);
    }

    @GetMapping("/chart")
    @Authentication(buyer = true, sale = true)
    public Result<HashMap<String, List<Map<String, String>>>> ChartInfoController() {
        HashMap<String, List<Map<String, String>>> data = new HashMap<>();
        data.put("salesRank", homeChartService.getSalesRankService());
        data.put("monthSales", homeChartService.getMonthSalesService());
        data.put("yearSales", homeChartService.getYearSalesService());
        return Result.success(data, "success");
    }
}
