package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Validated
@RestController
@RequestMapping("/stock")
public class StockPriceController extends BaseController {
    @Resource
    StockPriceService stockPriceService;

    @GetMapping("/price")
    @Authentication(buyer = true)
    public Result<Page<StockPriceVO>> getEnquiryMainListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "TypeCode") String typeCode,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "StockDays") Integer stockDays,
            @RequestParam(defaultValue = "#{null}", value = "NeedReplenish") Boolean needReplenish,
            @RequestParam(defaultValue = "#{null}", value = "PricingType") Integer pricingType

    ) {
        StockPriceSearchDTO stockPriceSearchDTO = new StockPriceSearchDTO();
        stockPriceSearchDTO.setPage(page);
        stockPriceSearchDTO.setSize(size);
        stockPriceSearchDTO.setBrand(brand);
        stockPriceSearchDTO.setModle(modle);
        stockPriceSearchDTO.setTypeCode(typeCode);
        stockPriceSearchDTO.setStockDays(stockDays);
        stockPriceSearchDTO.setNeedReplenish(needReplenish);
        stockPriceSearchDTO.setPricingType(pricingType);
        Page<StockPriceVO> pages = stockPriceService.list(stockPriceSearchDTO);
        return Result.success(pages, "Success");
    }

    @PatchMapping("/price")
    @Authentication(buyer = true)
    public Result<Boolean> okController(@RequestBody StockPriceOKDTO stockPriceOKDTO) {
        Boolean res = stockPriceService.update(stockPriceOKDTO);
        return Result.success(res, "Success");
    }
    @PutMapping("/price")
    public Result<Boolean> okAllController(@RequestBody StockPriceOKDTO stockPriceOKDTO) {
        Boolean res = stockPriceService.update(stockPriceOKDTO);
        return Result.success(res, "Success");
    }

}
