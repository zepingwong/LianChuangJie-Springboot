package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.ExchangeRateEntity;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.ExchangeRateService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateController {
    @Resource
    ExchangeRateService exchangeRateService;

    /**
     * @param currency currency
     * @return Result
     * @description 获取今日汇率
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/today")
    @Authentication(sale = true, buyer = true)
    public Result<BigDecimal> getTodayExchangeRateController(@RequestParam(defaultValue = "RMB", value = "Currency") String currency) {
        if (Objects.equals(currency, "RMB")) {
            return Result.success(new BigDecimal(1));
        }
        ExchangeRateEntity exchangeRate = exchangeRateService.getTodayExchangeRateService(currency);
        ResponseEnum.ISNULL.assertNotNull(exchangeRate);
        return Result.success(exchangeRate.getRate());
    }
}
