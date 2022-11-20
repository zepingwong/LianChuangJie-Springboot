package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Stock.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.mapper.Stock.StockQuantityMapper;
import com.lianchuangjie.lianchuangjie.service.StockQuantityService;
import org.springframework.stereotype.Service;

@Service
public class StockQuantityServiceImpl extends ServiceImpl<StockQuantityMapper, StockQuantityEntity> implements StockQuantityService {
}
