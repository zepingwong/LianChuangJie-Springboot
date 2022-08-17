package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabEnquiryController {
    @Resource
    EnquirySubService enquirySubService;
    /**
     * @param page  页码
     * @param size  每页显示数量
     * @param modle 单个型号
     * @return Result<Page < TabNeedsVO>>
     * @description 客户需求
     */
    @GetMapping("/enquiry/needs")
    @Authentication(buyer = true)
    public Result<Page<TabEnquiryNeedsVO>> getCusNeedsListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<TabEnquiryNeedsVO> pages = enquirySubService.enquiryTabList(tabSearchDTO);
        return Result.success(pages, "Success");
    }
}
