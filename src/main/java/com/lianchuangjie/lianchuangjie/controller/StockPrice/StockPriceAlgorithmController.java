package com.lianchuangjie.lianchuangjie.controller.StockPrice;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Validated
@RequestMapping("/stock")
public class StockPriceAlgorithmController extends BaseController {
    @Resource
    StockPriceAlgorithmService stockPriceAlgorithmService;
    /**
     * @return Result
     * @description 手动更新算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @PostMapping("/price/calculate")
    @Authentication(buyer = true)
    public Result<Boolean> calculateController(@RequestBody List<StockPriceVO> list) {
        Boolean res = stockPriceAlgorithmService.calculateADayService(list);
        return Result.success(res, "更新成功");
    }
    /**
     * @return Result
     * @description 算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @GetMapping("/price/recalculate")
    @Authentication(buyer = true)
    public Result<Boolean> recalculateController() {
        Boolean res = stockPriceAlgorithmService.calculateOneDayService("手动更新");
        return Result.success(res, "更新成功");
    }
}
