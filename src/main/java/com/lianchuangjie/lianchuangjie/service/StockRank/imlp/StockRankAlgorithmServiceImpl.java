package com.lianchuangjie.lianchuangjie.service.StockRank.imlp;

import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockRank.StockRankCalculateMapper;
import com.lianchuangjie.lianchuangjie.mapper.StockRank.StockRankLogMapper;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class StockRankAlgorithmServiceImpl implements StockRankAlgorithmService {
    @Resource
    StockRankCalculateMapper stockRankCalculateMapper;
    @Resource
    StockRankLogMapper stockRankLogMapper;
    @Resource
    RedisUtil<Boolean> redisUtil;

    @Override
    public Boolean calculate(String triggerType) {
        try {
            if (!redisUtil.hasKey("Algorithm:StockRank")) {
                redisUtil.setCacheObject("Algorithm:StockRank", false);
            }
            StockRankLogEntity stockRankLogEntity = new StockRankLogEntity();
            stockRankLogEntity.setTriggerType(triggerType);
            Boolean state = redisUtil.getCacheObject("Algorithm:StockRank");
            if (state) {
                throw new RuntimeException("算法正在运行，请稍后刷新结果");
            }
            redisUtil.setCacheObject("Algorithm:StockRank", true);
            stockRankCalculateMapper.calculate();
            // Redis复位
            redisUtil.setCacheObject("Algorithm:StockRank", false);
            stockRankLogEntity.setEndTime(new Date());
            stockRankLogEntity.setResult(1);
            stockRankLogMapper.insert(stockRankLogEntity);
            return true;
        } catch (Exception e) {
            redisUtil.setCacheObject("Algorithm:StockRank", false);
            throw new RuntimeException("调用算法失败");
        }
    }
}
