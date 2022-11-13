package com.lianchuangjie.lianchuangjie.controller.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceQuoteVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;
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
    TabQuotationService tabQuotationService;

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
    public Result<Page<TabStockPriceZNLVO>> getStockPriceZnl(@RequestParam(defaultValue = "1", value = "page") Integer page, @RequestParam(defaultValue = "10", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceZNLVO> res = tabZhengNengLiangService.stockPriceTabList(tabSearchDTO);
        return Result.success(res);
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-客户需求Tab
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
     * @description 库存定价-销售订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/sales")
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
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-采购订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/purchase")
    @Authentication(buyer = true)
    public Result<Page<TabQuotationPurchaseOrderVO>> getPurchaseListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabQuotationPurchaseOrderVO> pages = tabPurchaseOrderService.quotationTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-销售报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/enquiry")
    @Authentication(buyer = true)
    public Result<Page<TabStockPriceEnquiryVO>> getEnquiryListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        System.out.println("**********************************************");
        System.out.println(tabEnquiryService.stockPriceTabList(tabSearchDTO));
        Page<TabStockPriceEnquiryVO> pages = tabEnquiryService.stockPriceTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/stockrank/quote")
    @Authentication(buyer = true)
    public Result<Page<TabStockPriceQuoteVO>> getQuoteListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceQuoteVO> pages = tabQuotationService.stockPriceTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
