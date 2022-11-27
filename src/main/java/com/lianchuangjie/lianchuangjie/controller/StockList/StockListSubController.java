package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListCompleteDTO;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListSubController {
    @Resource
    StockListSubService stockListSubService;

    /**
     * @param page     page
     * @param size     size
     * @param docEntry docEntry
     * @return Result
     * @description 获取库存清单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/27/2022
     */
    @GetMapping("/list/{docEntry}")
    @Authentication(buyer = true)
    public Result<Page<StockListSubVO>> getStockListSubListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @PathVariable Long docEntry
    ) {
        StockListSubSearchDTO stockListSubSearchDTO = new StockListSubSearchDTO(
                page,
                size,
                docEntry
        );
        Page<StockListSubVO> pages = stockListSubService.list(stockListSubSearchDTO);
        return Result.success(pages, "Success");
    }

    @PostMapping("/list/complete")
    @Authentication(buyer = true)
    public Result<Boolean> stockListCompleteController (
            @RequestBody @Valid List<StockListCompleteDTO> stockListCompleteDTOList
    ) {
        System.out.println(stockListCompleteDTOList.get(0));
        stockListSubService.complete(stockListCompleteDTOList);
        return Result.success(true, "Success");
    }
}
