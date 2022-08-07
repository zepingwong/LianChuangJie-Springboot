package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquirySubService enquirySubService;
    @GetMapping("/main")
    @Authentication(sale = true)
    public Result<Page<EnquiryMainItemVO>> getEnquiryMainListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}",value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long OwnerCode,
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateStart") Date InvalidDateStart,
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateEnd") Date InvalidDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateStart") Date CreateDateStart,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateEnd") Date CreateDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String CardCode,
            @RequestParam(defaultValue = "#{null}", value = "State") Integer State
    ) {
        EnquiryMainSearchDTO searchCondition = new EnquiryMainSearchDTO();
        searchCondition.setPage(page);
        searchCondition.setSize(size);
        searchCondition.setOwnerCode(OwnerCode);
        searchCondition.setCardCode(CardCode);
        searchCondition.setState(State);
        searchCondition.setInvalidDateStart(InvalidDateStart);
        searchCondition.setInvalidDateEnd(InvalidDateEnd);
        searchCondition.setCreateDateStart(CreateDateStart);
        searchCondition.setCreateDateEnd(CreateDateEnd);
        Page<EnquiryMainItemVO> pages = enquiryMainService.getListService(searchCondition);
        return Result.success(pages);
    }

    @GetMapping("/main/{docEntry}")
    @Authentication(sale = true)
    public Result<EnquiryMainInfoVO> getEnquiryMainInfoController(@PathVariable Long docEntry) {
        return Result.success(enquiryMainService.getMainService(docEntry));
    }
    @GetMapping("/sub")
    @Authentication(sale = true)
    public Result<List<EnquirySubVO>> enquirySubController(
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        List<EnquirySubVO> list = enquirySubService.getListService(docEntry);
        return Result.success(list);
    }
}
