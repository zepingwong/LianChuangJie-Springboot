package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.TabService.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSalesOrderVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tab")
public class TabSearchController {
    @Resource
    TabSdadaService tabSdadaService;
    @Resource
    TabQuotationService tabQuotationService;
    @Resource
    TabClientNeedsService tabClientNeedsService;

    @Resource
    TabSalesOrderService tabSalesOrderService;
    @Resource
    TabPurchaseOrderService tabPurchaseOrderService;
    /**
     * @return Result
     * @description 模糊搜索-标准型号Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/search/sdada/{page}/{size}")
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<Page<TabSearchSdadaVO>> getStandardDataList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchSdadaVO> res = tabSdadaService.searchTabList(tabSearchDTO);
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
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<Page<TabSearchQuotationVO>> getQuotationList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchQuotationVO> res = tabQuotationService.searchTabList(tabSearchDTO);
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
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<Page<TabSearchNeedsVO>> getNeedsList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchNeedsVO> res = tabClientNeedsService.searchTabList(tabSearchDTO);
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
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<Page<TabSearchSalesOrderVO>> getSalesOrderList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size

    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchSalesOrderVO> res = tabSalesOrderService.searchTabList(tabSearchDTO);
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
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<Page<TabSearchPurchaseOrderVO>> getPurchaseOrderList(
            @RequestBody List<String> modleList,
            @PathVariable Integer page,
            @PathVariable Integer size
    ) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setModleList(modleList);
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        Page<TabSearchPurchaseOrderVO> res = tabPurchaseOrderService.searchTabList(tabSearchDTO);
        return Result.success(res);
    }
}
