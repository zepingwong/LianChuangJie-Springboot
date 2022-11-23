package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListSubController {
    @Resource
    StockListSubService stockListSubService;

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
}
