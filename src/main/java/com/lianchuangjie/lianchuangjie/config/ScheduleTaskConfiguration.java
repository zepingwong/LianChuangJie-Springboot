package com.lianchuangjie.lianchuangjie.config;

import com.alibaba.fastjson.JSONObject;
import com.lianchuangjie.lianchuangjie.mapper.UInquiryMapper;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

/**
 * 定时任务配置
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTaskConfiguration {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    UInquiryMapper uInquiryMapper;
    // 3.添加定时任务
    @Scheduled(cron = "0 0 2 * * ?")
    private void stockPrice() {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        if (!Objects.equals(state, "1")) {
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            String res;
            try {
                JSONObject json = new JSONObject();
                json.put("data", "111");
                res = HttpUtil.jsonPost("http://192.168.16.174:5582/model_predict_one_day", null, json);
                System.out.println(res);
                if (res != null) {
                    stringRedisTemplate.opsForValue().set("StockPrice", "0");
                }
            } catch (IOException e) {
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
