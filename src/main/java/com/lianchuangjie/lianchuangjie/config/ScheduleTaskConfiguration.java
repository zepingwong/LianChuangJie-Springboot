package com.lianchuangjie.lianchuangjie.config;

import com.lianchuangjie.lianchuangjie.mapper.UInquiryMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 定时任务配置
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTaskConfiguration {
    @Resource
    UInquiryMapper uInquiryMapper;
    @Resource
    StockPriceAlgorithmService stockPriceAlgorithmService;
    // 3.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")
    private void stockPrice() {
        stockPriceAlgorithmService.calculateOneDayService("定时任务");
    }
    @Scheduled(cron = "0 0 1 * * ?")
    private void yunhanPrice() {
        stockPriceAlgorithmService.yunhan();
    }
    @Scheduled(cron = "0 0 2 * * ?")
    private void updateUInquiry() {
        uInquiryMapper.daily();
    }
}
