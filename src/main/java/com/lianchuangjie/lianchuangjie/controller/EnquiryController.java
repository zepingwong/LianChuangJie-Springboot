package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquirySubItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.RecoPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquiryHotwordsService;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.EnquiryRecoPriceService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController extends BaseController {
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    EnquiryHotwordsService enquiryHotwordsService;
    @Resource
    EnquiryRecoPriceService enquiryRecoPriceService;

    @GetMapping("/main")
    @Authentication(sale = true)
    public Result<Page<EnquiryMainItemVO>> getEnquiryMainListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode, @RequestParam(defaultValue = "#{null}", value = "InvalidDateStart") Date invalidDateStart, @RequestParam(defaultValue = "#{null}", value = "InvalidDateEnd") Date invalidDateEnd, @RequestParam(defaultValue = "#{null}", value = "CreateDateStart") Date createDateStart, @RequestParam(defaultValue = "#{null}", value = "CreateDateEnd") Date createDateEnd, @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode, @RequestParam(defaultValue = "#{null}", value = "State") Integer state) {
        EnquiryMainSearchDTO searchCondition = new EnquiryMainSearchDTO();
        searchCondition.setPage(page);
        searchCondition.setSize(size);
        searchCondition.setOwnerCode(ownerCode);
        searchCondition.setCardCode(cardCode);
        searchCondition.setState(state);
        searchCondition.setInvalidDateStart(invalidDateStart);
        searchCondition.setInvalidDateEnd(invalidDateEnd);
        searchCondition.setCreateDateStart(createDateStart);
        searchCondition.setCreateDateEnd(createDateEnd);
        Page<EnquiryMainItemVO> pages = enquiryMainService.list(searchCondition);
        return Result.success(pages);
    }

    @GetMapping("/main/{docEntry}")
    @Authentication(sale = true)
    public Result<EnquiryMainInfoVO> getEnquiryMainInfoController(@PathVariable Long docEntry) {
        return Result.success(enquiryMainService.getOne(docEntry));
    }

    @GetMapping("/sub")
    @Authentication(sale = true)
    public Result<List<EnquirySubVO>> enquirySubController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        List<EnquirySubVO> list = enquirySubService.list(docEntry);
        return Result.success(list, "Success");
    }

    @PutMapping("/sub")
    @Authentication(sale = true)
    public Result<Boolean> saveEnquirySubController(@RequestBody List<EnquirySubItemDTO> enquirySubItemDTOList) {
        System.out.println(enquirySubItemDTOList);
        return null;
    }

    /**
     * @return 排名前两个的热搜词
     * @description 查询热搜词
     */
    @GetMapping("hotwords")
    @Authentication(sale = true)
    public Result<List<EnquiryHotwordsVO>> getEnquiryHotwords() {
        List<EnquiryHotwordsVO> list = enquiryHotwordsService.getList();
        return Result.success(list);
    }

    @GetMapping("/recommend")
    @Authentication(sale = true)
    public Result<List<EnquiryRecoPriceVO>> enquiryRecommendController(
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode,
            @RequestParam(defaultValue = "#{null}", value = "U_Region") String uRegion,
            @RequestParam(defaultValue = "#{null}", value = "U_CusGroupCode") String uCusGroupCode,
            @RequestParam(defaultValue = "#{null}", value = "U_DomainName") String uDomainName
    ) {
        RecoPriceSearchDTO recoPriceSearchDTO = new RecoPriceSearchDTO();
        recoPriceSearchDTO.setBrand(brand);
        recoPriceSearchDTO.setModle(modle);
        List<EnquiryRecoPriceVO> list = enquiryRecoPriceService.list(recoPriceSearchDTO);
        return Result.success(list);
    }
}
