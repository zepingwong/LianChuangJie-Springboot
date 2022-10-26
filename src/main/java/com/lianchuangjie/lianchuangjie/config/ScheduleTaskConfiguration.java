package com.lianchuangjie.lianchuangjie.config;

import com.alibaba.fastjson.JSONObject;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceLogMapper;
import com.lianchuangjie.lianchuangjie.mapper.UInquiryMapper;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * 定时任务配置
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTaskConfiguration {
    @Value("${algorithm_address}")
    private String address;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    UInquiryMapper uInquiryMapper;
    @Resource
    StockPriceLogMapper stockPriceLogMapper;
    // 3.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")
    private void stockPrice() {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setStartTime(new Date());
        stockPriceLogEntity.setTriggerType("定时任务");
        if (!Objects.equals(state, "1")) {
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            String res;
            try {
                JSONObject json = new JSONObject();
                json.put("data", "111");
                res = HttpUtil.jsonPost(address + "model_predict_one_day", null, json);
                System.out.println(res);
                if (res != null) {
                    stringRedisTemplate.opsForValue().set("StockPrice", "0");
                    stockPriceLogEntity.setEndTime(new Date());
                    stockPriceLogEntity.setResult(1);
                    stockPriceLogMapper.insert(stockPriceLogEntity);
                }
            } catch (IOException e) {
                stockPriceLogEntity.setEndTime(new Date());
                stockPriceLogEntity.setResult(0);
                stockPriceLogMapper.insert(stockPriceLogEntity);
                stringRedisTemplate.opsForValue().set("StockPrice", "0");
                throw new RuntimeException(e);
            }
        }
    }

    @Scheduled(cron = "0 0 2 * * ?")
    private void updateUInquiry() {
        uInquiryMapper.daily();
    }
}
