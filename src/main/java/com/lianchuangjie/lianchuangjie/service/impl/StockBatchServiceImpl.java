package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Stock.StockBatchEntity;
import com.lianchuangjie.lianchuangjie.mapper.Stock.StockBatchMapper;
import com.lianchuangjie.lianchuangjie.service.StockBatchService;
import org.springframework.stereotype.Service;

@Service
public class StockBatchServiceImpl extends ServiceImpl<StockBatchMapper, StockBatchEntity> implements StockBatchService {
}
