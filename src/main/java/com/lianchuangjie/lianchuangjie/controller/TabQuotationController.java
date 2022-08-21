package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabQuotationController {
    @Resource
    QuotationService quotationService;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    StockQuantityService stockQuantityService;
    @Resource
    SalesOrderSubService salesOrderSubService;
    @Resource
    PurchaseOrderSubService purchaseOrderSubService;

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 我的报价-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/quote/my")
    @Authentication(buyer = true)
    public Result<Page<TabMyQuotationVO>> getQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabMyQuotationVO> pages = quotationService.tabMyList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Result
     * @description 我的报价-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @PostMapping("/quote/my")
    @Authentication(buyer = true)
    public Result<Page<TabMyQuotationVO>> getQuotationListController(@RequestBody TabSearchDTO tabSearchDTO) {
        Page<TabMyQuotationVO> pages = quotationService.tabMyList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 客户需求-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/quote/needs")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationNeedsVO>> getCusNeedsListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationNeedsVO> pages = enquirySubService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Result
     * @description 客户需求-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @PostMapping("/quote/needs")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationNeedsVO>> getCusNeedsListController(@RequestBody TabSearchDTO tabSearchDTO) {
        Page<TabQuotationNeedsVO> pages = enquirySubService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
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
    @GetMapping("/quote/stock")
    @Authentication(buyer = true)
    public Result<Page<TabStockVO>> getStocksListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockVO> pages = stockQuantityService.tabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Result
     * @description 库存情况-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @PostMapping("/quote/stock")
    @Authentication(buyer = true)
    public Result<Page<TabStockVO>> getStocksListController(@RequestBody TabSearchDTO tabSearchDTO) {
        Page<TabStockVO> pages = stockQuantityService.tabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 销售订单-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/quote/sales")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationSalesOrderVO>> getSalesListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationSalesOrderVO> pages = salesOrderSubService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Result
     * @description 销售订单-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @PostMapping("/quote/sales")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationSalesOrderVO>> getSalesListController(@RequestBody TabSearchDTO tabSearchDTO) {
        Page<TabQuotationSalesOrderVO> pages = salesOrderSubService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 采购订单-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @GetMapping("/quote/purchase")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationPurchaseOrderVO>> getPurchaseListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationPurchaseOrderVO> pages = purchaseOrderSubService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
