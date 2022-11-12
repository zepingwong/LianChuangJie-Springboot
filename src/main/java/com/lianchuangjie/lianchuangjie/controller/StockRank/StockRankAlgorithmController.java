package com.lianchuangjie.lianchuangjie.controller.StockRank;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Validated
@RequestMapping("/stock")
public class StockRankAlgorithmController {
    @Resource
    StockRankAlgorithmService stockRankAlgorithmService;
    /**
     * @return Result
     * @description 手动触发库存排名算法
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @GetMapping("/rank/calculate")
    @Authentication(buyer = true)
    public Result<Boolean> recalculateController() {
        Boolean res = stockRankAlgorithmService.calculate("手动更新");
        return Result.success(res, "更新成功");
    }
}
