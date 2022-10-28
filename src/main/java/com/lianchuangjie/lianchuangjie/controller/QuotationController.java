package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.QuotationReplyDTO;
import com.lianchuangjie.lianchuangjie.dto.QuotationSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.service.User.UserInfoService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Quotation.QuotationVO;
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

    /**
     * @param page             page
     * @param size             size
     * @param modle            modle
     * @param brand            brand
     * @param uStatus          uStatus
     * @param inquiryDateStart inquiryDateStart
     * @param inquiryDateEnd   inquiryDateEnd
     * @param uBuyer           uBuyer
     * @param ownerCode        ownerCode
     * @return Result
     * @description 获取采购报价列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    @GetMapping("quote")
    @Authentication(buyer = true)
    public Result<Page<QuotationVO>> getQuotationListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "U_Status") String uStatus,
            @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateStart") Date inquiryDateStart,
            @RequestParam(defaultValue = "#{null}", required = false, value = "InquiryDateEnd") Date inquiryDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "U_Buyer") Long uBuyer,
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode,
            @RequestParam(defaultValue = "#{null}", value = "U_DeptCode") String uDeptCode
    ) {
        QuotationSearchDTO quotationSearchDTO = new QuotationSearchDTO();
        quotationSearchDTO.setPage(page);
        quotationSearchDTO.setSize(size);
        quotationSearchDTO.setModle(modle);
        quotationSearchDTO.setBrand(brand);
        quotationSearchDTO.setUBuyer(uBuyer);
        quotationSearchDTO.setUStatus(uStatus);
        quotationSearchDTO.setUDeptCode(uDeptCode);
        quotationSearchDTO.setOwnerCode(ownerCode);
        quotationSearchDTO.setInquiryDateStart(inquiryDateStart);
        quotationSearchDTO.setInquiryDateEnd(inquiryDateEnd);
        Page<QuotationVO> pages = quotationService.getList(quotationSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param quotationSaveDTO quotationSaveDTO
     * @return Result
     * @description 采购保存一条报价信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    @PostMapping("quote")
    @Authentication(buyer = true)
    public Result<Boolean> saveQuotationController(@RequestBody @Valid QuotationSaveDTO quotationSaveDTO) {
        QuotationEntity quotationEntity = new QuotationEntity();
        BeanUtils.copyProperties(quotationSaveDTO, quotationEntity);
        QueryWrapper<QuotationEntity> queryWrapper = new QueryWrapper<>();
        // T_ICIN1.LineNum表示报价次数
        queryWrapper.eq("DocEntry", quotationSaveDTO.getUBaseEntry());
        quotationEntity.setLineNum(quotationService.count(queryWrapper) + 1);
        return Result.success(quotationService.save(quotationEntity));
    }

    /**
     * @param quotationReplyDTO quotationReplyDTO
     * @return Result
     * @description 采购回复一条报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    @PatchMapping("quote")
    @Authentication(buyer = true)
    public Result<Boolean> replyQuotationController(@RequestBody @Valid QuotationReplyDTO quotationReplyDTO) {
        Boolean res = quotationService.reply(quotationReplyDTO);
        return Result.success(res, "Success");
    }
}
