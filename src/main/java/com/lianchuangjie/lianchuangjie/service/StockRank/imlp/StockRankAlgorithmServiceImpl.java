package com.lianchuangjie.lianchuangjie.service.StockRank.imlp;

import com.lianchuangjie.lianchuangjie.mapper.StockRank.StockRankCalculateMapper;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class StockRankAlgorithmServiceImpl implements StockRankAlgorithmService {
    @Resource
    StockRankCalculateMapper stockRankCalculateMapper;
    @Resource
    RedisUtil redisUtil;
    @Override
    public Boolean calculate(String triggerType) {

        String state = redisUtil.getString("StockRank");
        if (Objects.equals(state, "1")) {
            throw new RuntimeException("算法正在运行，请稍后刷新结果");
        }
        redisUtil.setString("StockRank", "1");
        stockRankCalculateMapper.calculate();
        redisUtil.setString("StockRank", "0");
        return true;
    }
}
