package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.searchDTO.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/")
public class QuotationController extends BaseController{
    @Resource
    QuotationService quotationService;

    @GetMapping("quote")
    @Authentication(buyer = true)
    public Result<Page<QuotationVO>> enquirySubController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "U_Status") String uStatus,
            @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateStart") Date inquiryDateStart,
            @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateEnd") Date inquiryDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "U_Buyer") Long uBuyer,
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode
    ) {
        QuotationSearchDTO quotationSearchDTO = new QuotationSearchDTO();
        quotationSearchDTO.setPage(page);
        quotationSearchDTO.setSize(size);
        quotationSearchDTO.setModle(modle);
        quotationSearchDTO.setBrand(brand);
        quotationSearchDTO.setUBuyer(uBuyer);
        quotationSearchDTO.setUStatus(uStatus);
        quotationSearchDTO.setOwnerCode(ownerCode);
        quotationSearchDTO.setInquiryDateStart(inquiryDateStart);
        quotationSearchDTO.setInquiryDateEnd(inquiryDateEnd);
        Page<QuotationVO> pages = quotationService.list(quotationSearchDTO);
        return Result.success(pages, "Success");
    }
}
