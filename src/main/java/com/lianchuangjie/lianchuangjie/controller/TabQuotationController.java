package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.service.SalesOrderSubService;
import com.lianchuangjie.lianchuangjie.service.StockQuantityService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.TabMyQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * @param page  页码
     * @param size  每页显示数量
     * @param modle 单个型号
     * @return Page<TabMyQuotationVO>
     * @description 我的报价-单个型号
     */
    @GetMapping("/quote/my")
    @Authentication(buyer = true)
    public Result<Page<TabMyQuotationVO>> getQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabMyQuotationVO> pages = quotationService.tabMy(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  页码
     * @param size  每页显示数量
     * @param modle 单个型号
     * @return Result<Page < TabNeedsVO>>
     * @description 客户需求
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
     * @param page  页码
     * @param size  每页显示数量
     * @param modle 单个型号
     * @return Page<TabStockVO>
     * @description 库存数量-单个型号
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
     *
     */
    @GetMapping("/quote/sale")
    @Authentication(buyer = true)
    public Result<Page<TabSalesOrderVO>> getSaleListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabSalesOrderVO> pages = salesOrderSubService.tabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
