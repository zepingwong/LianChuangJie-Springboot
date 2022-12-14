package com.lianchuangjie.lianchuangjie.controller.StockPrice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceService;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/tab")
public class TabStockPriceController extends BaseController {
    @Resource
    TabPurchaseOrderService tabPurchaseOrderService;
    // 客户需求
    @Resource
    TabClientNeedsService tabClientNeedsService;
    // 销售报价
    @Resource
    TabEnquiryService tabEnquiryService;

    @Resource
    StockPriceService stockPriceService;
    @Resource
    TabZhengNengLiangService tabZhengNengLiangService;
    @Resource
    TabSalesOrderService tabSalesOrderService;

    @Resource
    TabQuotationService tabQuotationService;
    @Resource
    TabStockService tabStockService;


    @GetMapping("/stockprice/origin")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabStockPriceOriginVO>> getStockPriceOrigin(
            @RequestParam(defaultValue = "1", value = "page") Integer page,
            @RequestParam(defaultValue = "10", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceOriginVO> res = tabStockService.stockPriceTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @param page  page
     * @param size  size
     * @param modle modle
     * @return Result
     * @description 库存定价-基本信息TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
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
    @GetMapping("/stockprice/znl")
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
    @GetMapping("/stockprice/needs")
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
    @GetMapping("/stockprice/sales")
    @Authentication(buyer = true)
    public Result<Page<TabStockPriceSalesOrderVO>> getSalesListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPriceSalesOrderVO> pages = tabSalesOrderService.stockPriceTabList(tabSearchDTO);
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
    @GetMapping("/stockprice/purchase")
    @Authentication(buyer = true)
    public Result<Page<TabStockPricePurchaseOrderVO>> getPurchaseListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabStockPricePurchaseOrderVO> pages = tabPurchaseOrderService.stockPriceTabList(tabSearchDTO);
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
    @GetMapping("/stockprice/enquiry")
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
    @GetMapping("/stockprice/quote")
    @Authentication(buyer = true)
    public Result<Page<TabStockPriceQuoteVO>> getQuoteListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "QuoDateStart") Date quoDateStart,
            @RequestParam(defaultValue = "#{null}", value = "QuoDateEnd") Date quoDateEnd
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        tabSearchDTO.setQuoDateStart(quoDateStart);
        tabSearchDTO.setQuoDateEnd(quoDateEnd);
        Page<TabStockPriceQuoteVO> pages = tabQuotationService.stockPriceTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
