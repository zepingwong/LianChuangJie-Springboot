package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryAvailableSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryAvailableService;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabEnquiryController {
    @Resource
    TabClientNeedsService tabClientNeedsService;
    @Resource
    TabQuotationService tabQuotationService;

    @Resource
    TabSalesOrderService tabSalesOrderService;
    @Resource
    TabPurchaseOrderService tabPurchaseOrderService;
    @Resource
    TabStockService tabStockService;
    @Resource
    EnquiryAvailableService enquiryAvailableService;

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 客户需求Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @GetMapping("/enquiry/needs")
    @Authentication(sale = true)
    public Result<Page<TabEnquiryNeedsVO>> getCusNeedsListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquiryNeedsVO> pages = tabClientNeedsService.enquiryTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 采购报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("/enquiry/quote")
    @Authentication(sale = true)
    public Result<Page<TabEnquiryQuotationVO>> getQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquiryQuotationVO> pages = tabQuotationService.enquiryTabList(tabSearchDTO);
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
     * @date 8/21/2022
     */
    @GetMapping("/enquiry/sales")
    @Authentication(sale = true)
    public Result<Page<TabEnquirySalesOrderVO>> getSalesListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquirySalesOrderVO> pages = tabSalesOrderService.enquiryTabList(tabSearchDTO);
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
     * @date 8/21/2022
     */
    @GetMapping("/enquiry/purchase")
    @Authentication(sale = true)
    public Result<Page<TabEnquiryPurchaseOrderVO>> getPurchaseListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquiryPurchaseOrderVO> pages = tabPurchaseOrderService.enquiryTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存情况-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("/enquiry/stock")
    @Authentication(sale = true)
    public Result<Page<TabEnquiryStockVO>> getStocksListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquiryStockVO> pages = tabStockService.enquiryTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    @GetMapping("/enquiry/available")
    @Authentication(sale = true)
    public Result<Page<TabEnquiryAvailableVO>> getAvailableListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry
    ) {
        EnquiryAvailableSearchDTO tabSearchDTO = new EnquiryAvailableSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        tabSearchDTO.setDocEntry(docEntry);
        Page<TabEnquiryAvailableVO> pages = enquiryAvailableService.list(tabSearchDTO);
        return Result.success(pages, "成功");
    }
}
