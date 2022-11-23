package com.lianchuangjie.lianchuangjie.service.StockList.impl;

import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListMapper;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StockListServiceImpl implements StockListService {
    @Resource
    StockListMapper stockListMapper;
    @Override
    public List<BigDecimal> purchasePriceList(String modle) {
        return stockListMapper.selectPurchasePrice(modle);
    }
}
