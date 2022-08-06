package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.EnquiryService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
    @Resource
    EnquiryService enquiryService;
    @GetMapping("/main/{docEntry}")
    @Authentication(sale = true)
    public Result<EnquiryMainVO> getEnquiryMainInfoController(@PathVariable Long docEntry) {
        return Result.success(enquiryService.getEnquiryMainService(docEntry));
    }
}
