package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tab")
public class TabSearchController {
    @Resource
    SdadaService sdadaService;
    @Resource
    QuotationService quotationService;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    SalesOrderSubService salesOrderSubService;
    @Resource
    PurchaseOrderSubService purchaseOrderSubService;
    /**
     * @return Result
     * @description 模糊搜索-标准型号Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/sdada/{page}/{size}")
    @Authentication(sale = true, buyer = true)
    public Result<Page<SdadaVO>> getStandardDataList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<SdadaVO> res = sdadaService.tabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @return Result
     * @description 模糊搜索-采购报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/quote/{page}/{size}")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabSearchQuotationVO>> getQuotationList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchQuotationVO> res = quotationService.searchTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @return Result
     * @description 模糊搜索-客户需求Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/needs/{page}/{size}")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabSearchNeedsVO>> getNeedsList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchNeedsVO> res = enquirySubService.searchTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @return Result
     * @description 模糊搜索-销售订单Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/sales/{page}/{size}")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabSearchSalesOrderVO>> getSalesOrderList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchSalesOrderVO> res = salesOrderSubService.searchTabList(tabSearchDTO);
        return Result.success(res);
    }
    /**
     * @return Result
     * @description 模糊搜索-采购订单Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/purchase/{page}/{size}")
    @Authentication(sale = true, buyer = true)
    public Result<Page<TabSearchPurchaseOrderVO>> getPurchaseOrderList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchPurchaseOrderVO> res = purchaseOrderSubService.searchTabList(tabSearchDTO);
        return Result.success(res);
    }
}
