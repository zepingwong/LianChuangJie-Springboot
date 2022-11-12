package com.lianchuangjie.lianchuangjie.service.CurVat;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.CurVat.ExchangeRateEntity;

public interface ExchangeRateService extends IService<ExchangeRateEntity> {
    ExchangeRateEntity getTodayExchangeRateService(String currency);
}
