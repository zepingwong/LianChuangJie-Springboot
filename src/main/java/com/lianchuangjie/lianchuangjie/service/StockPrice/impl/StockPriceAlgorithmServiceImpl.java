package com.lianchuangjie.lianchuangjie.service.StockPrice.impl;

import com.alibaba.fastjson.JSONObject;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceAlgorithmMapper;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceLogMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class StockPriceAlgorithmServiceImpl implements StockPriceAlgorithmService {
    @Resource
    StockPriceLogMapper stockPriceLogMapper;
    @Resource
    StockPriceAlgorithmMapper stockPriceAlgorithmMapper;
    @Resource
    RedisUtil<Boolean> redisUtil;
    @Value("${algorithm_address}")
    private String address;

    @Override
    public Boolean calculateOneDayService(String triggerType) {
        if (!redisUtil.hasKey("Algorithm:StockPrice")) {
            redisUtil.setCacheObject("Algorithm:StockPrice", false);
        }
        Boolean state = redisUtil.getCacheObject("Algorithm:StockPrice");
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setTriggerType(triggerType);
        stockPriceLogEntity.setTriggerName("定价计算");
        String res;
        try {
            if (state) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            redisUtil.setCacheObject("Algorithm:StockPrice", true);
            JSONObject json = new JSONObject();
            json.put("data", "one_day");
            res = HttpUtil.jsonPost(address + "model_predict_one_day", null, json);
            // 算法执行成功
            if (res != null) {
                redisUtil.setCacheObject("Algorithm:StockPrice", false);
                stockPriceLogEntity.setResult(1);
            }
        } catch (IOException e) {
            // 接口调用失败
            redisUtil.setCacheObject("Algorithm:StockPrice", false);
            stockPriceLogEntity.setResult(0);
            throw new RuntimeException(e);
        } finally {
            stockPriceLogEntity.setEndTime(new Date());
            stockPriceLogMapper.insert(stockPriceLogEntity);
        }
        return true;
    }

    @Override
    public Boolean calculateADayService(List<StockPriceVO> list) {
        if (!redisUtil.hasKey("Algorithm:StockPrice")) {
            redisUtil.setCacheObject("Algorithm:StockPrice", false);
        }
        Boolean state = redisUtil.getCacheObject("Algorithm:StockPrice");
        String res;
        try {
            if (state) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            redisUtil.setCacheObject("Algorithm:StockPrice", true);
            JSONObject json = new JSONObject();
            json.put("data", list);
            res = HttpUtil.jsonPost(address + "model_predict_a_day", null, json);
            if (res != null) {
                redisUtil.setCacheObject("Algorithm:StockPrice", false);
            }
        } catch (IOException e) {
            redisUtil.setCacheObject("Algorithm:StockPrice", false);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Boolean trainService(String triggerType) {
        if (!redisUtil.hasKey("Algorithm:StockPriceTrain")) {
            redisUtil.setCacheObject("Algorithm:StockPriceTrain", false);
        }
        Boolean state = redisUtil.getCacheObject("Algorithm:StockPriceTrain");
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setTriggerType(triggerType);
        stockPriceLogEntity.setTriggerName("模型训练");
        String res;
        try {
            if (state) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            redisUtil.setCacheObject("Algorithm:StockPriceTrain", true);
            JSONObject json = new JSONObject();
            json.put("data", "modle_train");
            res = HttpUtil.jsonPost(address + "model_train", null, json);
            if (res != null) {
                stockPriceLogEntity.setResult(1);
                redisUtil.setCacheObject("Algorithm:StockPriceTrain", false);
            }
        } catch (IOException e) {
            stockPriceLogEntity.setResult(0);
            throw new RuntimeException(e);
        } finally {
            // 缓存状态复位
            redisUtil.setCacheObject("Algorithm:StockPriceTrain", false);
            stockPriceLogEntity.setEndTime(new Date());
            stockPriceLogMapper.insert(stockPriceLogEntity);
        }
        return true;
    }

    @Override
    public void yunhan() {
        StockPriceLogEntity stockPriceLogEntity = new StockPriceLogEntity();
        stockPriceLogEntity.setTriggerType("定时任务");
        stockPriceLogEntity.setTriggerName("云汉报价");
        stockPriceAlgorithmMapper.yunhan();
        stockPriceLogEntity.setResult(1);
        stockPriceLogEntity.setEndTime(new Date());
        stockPriceLogMapper.insert(stockPriceLogEntity);
    }
}
