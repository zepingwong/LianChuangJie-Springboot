package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CurVat.ExchangeRateEntity;
import com.lianchuangjie.lianchuangjie.mapper.CurVat.ExchangeRateMapper;
import com.lianchuangjie.lianchuangjie.service.CurVat.ExchangeRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExchangeRateServiceImpl extends ServiceImpl<ExchangeRateMapper, ExchangeRateEntity> implements ExchangeRateService {
    @Resource
    ExchangeRateMapper exchangeRateMapper;
    @Override
    public ExchangeRateEntity getTodayExchangeRateService(String currency) {
        return exchangeRateMapper.selectOne(currency);
    }
}
