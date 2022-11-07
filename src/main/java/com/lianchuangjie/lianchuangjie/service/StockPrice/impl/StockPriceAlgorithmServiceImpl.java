package com.lianchuangjie.lianchuangjie.service.StockPrice.impl;

import com.alibaba.fastjson.JSONObject;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceLogMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class StockPriceAlgorithmServiceImpl implements StockPriceAlgorithmService {
    @Resource
    StockPriceLogMapper stockPriceLogMapper;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Value("${algorithm_address}")
    private String address;

    @Override
    public Boolean calculateOneDayService(String triggerType) {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setStartTime(new Date());
        stockPriceLogEntity.setTriggerType(triggerType);
        stockPriceLogEntity.setTriggerName("定价计算");
        String res;
        try {
            if (Objects.equals(state, "1")) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            JSONObject json = new JSONObject();
            json.put("data", "one_day");
            res = HttpUtil.jsonPost(address + "model_predict_one_day", null, json);
            if (res != null) {
                stringRedisTemplate.opsForValue().set("StockPrice", "0");
                stockPriceLogEntity.setEndTime(new Date());
                stockPriceLogEntity.setResult(1);
                stockPriceLogMapper.insert(stockPriceLogEntity);
            }
        } catch (IOException e) {
            stringRedisTemplate.opsForValue().set("StockPrice", "0");
            stockPriceLogEntity.setEndTime(new Date());
            stockPriceLogEntity.setResult(1);
            stockPriceLogMapper.insert(stockPriceLogEntity);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Boolean calculateADayService(List<StockPriceVO> list) {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        String res;
        try {
            if (Objects.equals(state, "1")) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            JSONObject json = new JSONObject();
            json.put("data", list);
            res = HttpUtil.jsonPost(address + "model_predict_a_day", null, json);
            if (res != null) {
                stringRedisTemplate.opsForValue().set("StockPrice", "0");
            }
        } catch (IOException e) {
            stringRedisTemplate.opsForValue().set("StockPrice", "0");
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Boolean trainService(String triggerType) {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setStartTime(new Date());
        stockPriceLogEntity.setTriggerType(triggerType);
        stockPriceLogEntity.setTriggerName("模型训练");
        String res;
        try {
            if (Objects.equals(state, "1")) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            JSONObject json = new JSONObject();
            json.put("data", "modle_train");
            res = HttpUtil.jsonPost(address + "model_train", null, json);
            if (res != null) {
                stringRedisTemplate.opsForValue().set("StockPrice", "0");
                stockPriceLogEntity.setEndTime(new Date());
                stockPriceLogEntity.setResult(1);
                stockPriceLogMapper.insert(stockPriceLogEntity);
            }
        } catch (IOException e) {
            stringRedisTemplate.opsForValue().set("StockPrice", "0");
            stockPriceLogEntity.setEndTime(new Date());
            stockPriceLogEntity.setResult(1);
            stockPriceLogMapper.insert(stockPriceLogEntity);
            throw new RuntimeException(e);
        }
        return true;
    }
}
