package com.lianchuangjie.lianchuangjie.controller.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabStockRankController {
    @Resource
    TabPurchaseOrderService tabPurchaseOrderService;
    // 客户需求
    @Resource
    TabClientNeedsService tabClientNeedsService;
    // 销售报价
    @Resource
    TabEnquiryService tabEnquiryService;
    @Resource
    TabZhengNengLiangService tabZhengNengLiangService;
    @Resource
    TabSalesOrderService tabSalesOrderService;
    @Resource
    TabSdadaService tabSdadaService;
    @Resource
    TabStockService tabStockService;

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-正能量网Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/znl")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabStockRankZNLVO>> getStockPriceZnl(@RequestParam(defaultValue = "1", value = "page") Integer page, @RequestParam(defaultValue = "10", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockRankZNLVO> res = tabZhengNengLiangService.stockRankTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 标准型号-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @GetMapping("/stockrank/sdada")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabStockRankSdadaVO>> getStandardDataOne(
            @RequestParam(defaultValue = "1", value = "page") Integer page,
            @RequestParam(defaultValue = "10", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockRankSdadaVO> res = tabSdadaService.stockRankTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 库存情况-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/stockrank/stock")
    @Authentication(buyer = true)
    public Result<Page<TabStockRankStockVO>> getStocksListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockRankStockVO> pages = tabStockService.stockRankTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存排名-客户需求Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/needs")
    @Authentication(buyer = true)
    public Result<Page<TabStockPriceNeedsVO>> getCusNeedsListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceNeedsVO> pages = tabClientNeedsService.stockPriceTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存排名-销售订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/sales")
    @Authentication(buyer = true)
    public Result<Page<TabStockRankSalesOrderVO>> getSalesListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockRankSalesOrderVO> pages = tabSalesOrderService.stockRankTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存排名-采购订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/purchase")
    @Authentication(buyer = true)
    public Result<Page<TabStockRankPurchaseOrderVO>> getPurchaseListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockRankPurchaseOrderVO> pages = tabPurchaseOrderService.stockRankTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
