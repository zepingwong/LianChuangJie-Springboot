package com.lianchuangjie.lianchuangjie.task;

import com.lianchuangjie.lianchuangjie.mapper.UInquiryMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankAlgorithmService;
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
    @Resource
    StockRankAlgorithmService stockRankAlgorithmService;

    /**
     * @description 每日库存定价计算
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/30/2022
     */
    // 3.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")
    private void stockPrice() {
        stockPriceAlgorithmService.calculateOneDayService("定时任务");
    }

    /**
     * @description 库存定价的云汉报价定时任务
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/30/2022
     */
    @Scheduled(cron = "0 0 1 * * ?")
    private void yunhanPrice() {
        stockPriceAlgorithmService.yunhan();
    }

    /**
     * @description U_Inquiry的定时任务
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */

    @Scheduled(cron = "0 0 2 * * ?")
    private void updateUInquiry() {
        uInquiryMapper.daily();
    }

    /**
     * @description 库存排名定时任务
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/15/2022
     */
    @Scheduled(cron = "0 0 3 * * ?")
    private void calculateStockRank() {
        stockRankAlgorithmService.calculate("定时任务");
    }
}
