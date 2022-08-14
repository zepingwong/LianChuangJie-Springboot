package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.QuotationSaveDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.searchDTO.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.service.UserInfoService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/")
@Validated
public class QuotationController extends BaseController {
    @Resource
    QuotationService quotationService;
    @Resource
    UserInfoService userInfoService;

    @GetMapping("quote")
    @Authentication(buyer = true)
    public Result<Page<QuotationVO>> getQuotationListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle, @RequestParam(defaultValue = "#{null}", value = "Brand") String brand, @RequestParam(defaultValue = "#{null}", value = "U_Status") String uStatus, @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateStart") Date inquiryDateStart, @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateEnd") Date inquiryDateEnd, @RequestParam(defaultValue = "#{null}", value = "U_Buyer") Long uBuyer, @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode) {
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

    @PostMapping("quote")
    @Authentication(buyer = true)
    public Result<Boolean> saveQuotationController(@RequestBody @Valid QuotationSaveDTO quotationSaveDTO) {
        // 报价状态，为 ”Y“ 表示已经 reply；”N“ 仅代表 save
        quotationSaveDTO.setUStatus("N");
        QuotationEntity quotationEntity = new QuotationEntity();
        System.out.println(quotationSaveDTO);
        BeanUtils.copyProperties(quotationSaveDTO, quotationEntity);
        System.out.println(quotationEntity);
        QueryWrapper<QuotationEntity> queryWrapper = new QueryWrapper<>();
        // T_ICIN1.LineNum表示报价次数
        queryWrapper.eq("DocEntry", quotationSaveDTO.getDocEntry());
        quotationEntity.setLineNum(quotationService.count() + 1);
        // 采购员和采购部门信息
        Long userSign = SessionUtil.getUserSign();
        quotationEntity.setUBuyer(userSign);
        QueryWrapper<UserInfoVO> userInfoVOQueryWrapper = new QueryWrapper<>();
        userInfoVOQueryWrapper.eq("UserSign", userSign); // 采购员编号
        UserInfoVO user = userInfoService.getOne(userInfoVOQueryWrapper);
        quotationEntity.setUserName(user.getUserName()); // 采购员姓名
        quotationEntity.setUDftDept(user.getDftDept()); // 采购部门代码
        quotationEntity.setUDftDeptName(user.getDftDeptName()); // 采购部门名称
        return Result.success(quotationService.save(quotationEntity));
    }
}
