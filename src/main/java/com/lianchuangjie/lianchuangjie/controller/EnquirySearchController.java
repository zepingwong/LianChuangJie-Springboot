package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquirySearchService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.SearchQueryVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/enquiry")
public class EnquirySearchController {
    @Resource
    EnquirySearchService enquirySearchService;
    @GetMapping("/search")
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
        Page<SearchQueryVO> res = enquirySearchService.list(enquirySearchDTO);
        return Result.success(res, "success");
    }
}
