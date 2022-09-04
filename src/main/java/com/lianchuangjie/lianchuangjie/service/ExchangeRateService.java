package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ExchangeRateEntity;

public interface ExchangeRateService extends IService<ExchangeRateEntity> {
    ExchangeRateEntity getTodayExchangeRateService(String currency);
}
