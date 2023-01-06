package com.lianchuangjie.lianchuangjie.service.Home.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.Home.HomeToDoMapper;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceMapper;
import com.lianchuangjie.lianchuangjie.service.Home.HomeToDoService;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceService;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class HomeToDoServiceImpl implements HomeToDoService {
    @Resource
    HomeToDoMapper homeToDoMapper;
    @Resource
    StockPriceMapper stockPriceMapper;
    @Resource
    StockPriceService stockPriceService;

    @Override
    public Map<String, Long> getToDoNum(HttpServletRequest request) {
        Map<String, Long> map = new HashMap<>();
        UserEntity user = ContextUtil.getUser();
        if (Objects.equals(user.getUIsSale(), "Y")) {
            map.put("Enquiry", homeToDoMapper.countEnquiry(user.getUserSign()));
        }
        if (Objects.equals(user.getUIsBuyer(), "Y")) {
            map.put("Quotation", homeToDoMapper.countQuotation(user.getUserSign()));
            QueryWrapper<StockPriceEntity> queryWrapper = new QueryWrapper<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date currentTime = new Date();
            queryWrapper.eq("DocDate", formatter.format(currentTime));
            map.put("StockPriceAll", stockPriceService.count(queryWrapper));
            queryWrapper.eq("Modify", "Y");
            map.put("StockPriceFinished", stockPriceService.count(queryWrapper));
        }
        return map;
    }
}
