package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.service.ZhengNengLiangSubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceBaseVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceZNLVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabStockPriceController {
    @Resource
    StockPriceService stockPriceService;
    @Resource
    ZhengNengLiangSubService zhengNengLiangSubService;

    @GetMapping("/stockprice/base")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabStockPriceBaseVO>> getStockPriceBase(
            @RequestParam(defaultValue = "1", value = "page") Integer page,
            @RequestParam(defaultValue = "10", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceBaseVO> res = stockPriceService.tabList(tabSearchDTO);
        return Result.success(res);
    }

    @GetMapping("/stockprice/znl")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabStockPriceZNLVO>> getStockPriceZnl(
            @RequestParam(defaultValue = "1", value = "page") Integer page,
            @RequestParam(defaultValue = "10", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceZNLVO> res = zhengNengLiangSubService.tabList(tabSearchDTO);
        return Result.success(res);
    }

}
