package com.lianchuangjie.lianchuangjie.controller.Quotation;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Quotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabQuotationController {
    @Resource
    TabQuotationService tabQuotationService;
    @Resource
    TabClientNeedsService tabClientNeedsService;
    @Resource
    TabSalesOrderService tabSalesOrderService;
    @Resource
    TabPurchaseOrderService tabPurchaseOrderService;
    @Resource
    TabSdadaService tabSdadaService;
    @Resource
    TabStockService tabStockService;

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
    public Result<Page<TabMyQuotationVO>> getMyQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabMyQuotationVO> pages = tabQuotationService.tabMyList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 有效报价-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/quote/effective")
    @Authentication(buyer = true)
    public Result<Page<TabEffectiveQuotationVO>> getEffectiveQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEffectiveQuotationVO> pages = tabQuotationService.tabEffectiveList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 客户需求Tab
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
        Page<TabQuotationNeedsVO> pages = tabClientNeedsService.quotationTabList(tabSearchDTO);
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
    public Result<Page<TabQuotationStockVO>> getStocksListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationStockVO> pages = tabStockService.quotationTabList(tabSearchDTO);
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
        Page<TabQuotationSalesOrderVO> pages = tabSalesOrderService.quotationTabList(tabSearchDTO);
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
        Page<TabQuotationPurchaseOrderVO> pages = tabPurchaseOrderService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
    @GetMapping("/quote/sdada")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabQuotationSdadaVO>> getStandardDataOne(@RequestParam(defaultValue = "1", value = "page") Integer page, @RequestParam(defaultValue = "10", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationSdadaVO> res = tabSdadaService.quotationTabList(tabSearchDTO);
        return Result.success(res);
    }
}
