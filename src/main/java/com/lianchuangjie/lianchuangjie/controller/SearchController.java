package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import com.lianchuangjie.lianchuangjie.vo.SearchQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/search")
public class SearchController extends BaseController {
    @Resource
    QueryService queryService;
    @Resource
    SdadaService sdadaService;
    @Resource
    EnquiryBuyerService enquiryBuyerService;
    @Resource
    SearchService searchService;
    @GetMapping("/query")
    @Authentication(sale = true)
    public Result<Page<SearchQueryVO>> enquirySubController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page, // 页码
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size, // 每页显示条数
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        EnquirySearchDTO enquirySearchDTO = new EnquirySearchDTO();
        enquirySearchDTO.setModle(modle);
        enquirySearchDTO.setPage(page);
        enquirySearchDTO.setSize(size);
        Page<SearchQueryVO> res = searchService.list(enquirySearchDTO);
        return Result.success(res, "success");
    }

    /**
     * @param singleQueryDTO singleQueryDTO
     * @return Result
     * @description 单个型号询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @PostMapping("/query/single")
    @Authentication(sale = true)
    public Result<BomQueryItemVO> querySingleController(@RequestBody SingleQueryDTO singleQueryDTO) {
        BomQueryItemVO bomQueryItem = queryService.querySingle(singleQueryDTO);
        return Result.success(bomQueryItem);
    }

    @PostMapping("/query/related")
    @Authentication(sale = true)
    public Result<List<BomQueryItemVO>> queryRelatedController(@RequestBody SingleQueryDTO singleQueryDTO) {
        List<BomQueryItemVO> list = queryService.queryRelated(singleQueryDTO);
        return Result.success(list);
    }

    /**
     * 根据品牌查询采购人员
     *
     * @param brand 品牌
     * @return buyers
     */
    @GetMapping("buyer")
    @Authentication(sale = true)
    public Result<List<EnquiryBuyerItemVO>> getPurchaserController(@RequestParam(name = "Brand", defaultValue = "#{null}") String brand, @RequestParam(name = "ECCN", defaultValue = "#{null}") String eccn, @RequestParam(name = "TotalPrice", defaultValue = "#{null}") BigDecimal totalPrice, @RequestParam(name = "SlpCode", defaultValue = "#{null}") Long slpCode, @RequestParam(name = "DeptCode", defaultValue = "#{null}") String deptCode) {
        EnquiryBuyerSearchDTO enquiryBuyerSearchDTO = new EnquiryBuyerSearchDTO();
        enquiryBuyerSearchDTO.setBrand(brand);
        enquiryBuyerSearchDTO.setSlpCode(slpCode);
        enquiryBuyerSearchDTO.setDeptCode(deptCode);
        enquiryBuyerSearchDTO.setEccn(eccn);
        enquiryBuyerSearchDTO.setStartTotal(totalPrice);
        List<EnquiryBuyerItemVO> list = enquiryBuyerService.list(enquiryBuyerSearchDTO);
        return Result.success(list, "Success");
    }

    /**
     * @param modle modle
     * @return Result
     * @description 型号模糊搜索
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("/snosuggestion")
    @Authentication(sale = true, buyer = true)
    public Result<List<SdadaVO>> getSnosuggestionController(@RequestParam(name = "Modle", defaultValue = "#{null}") String modle) {
        List<SdadaVO> list = sdadaService.containList(modle);
        return Result.success(list, "Success");
    }

    /**
     * @param modle modle
     * @return Result
     * @description 查询关联型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("related")
    @Authentication(sale = true, buyer = true)
    public Result<List<SdadaVO>> getRelatedListController(@RequestParam(name = "Modle", defaultValue = "#{null}") String modle) {
        List<SdadaVO> list = sdadaService.relatedList(modle);
        return Result.success(list, "Success");
    }


}
