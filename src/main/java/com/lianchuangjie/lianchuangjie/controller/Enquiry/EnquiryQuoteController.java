package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquiryExportSaveDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryQuoteService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/enquiry")
public class EnquiryQuoteController {
    @Resource
    EnquiryQuoteService enquiryQuoteService;

    /**
     * @param docEntry docEntry
     * @return Result
     * @description 销售获取报价单列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @GetMapping("/quote/{docEntry}")
    @Authentication(sale = true)
    public Result<EnquiryExportDataVO> exportController(@PathVariable Long docEntry) {
        EnquiryExportDataVO enquiryExportDataVO = enquiryQuoteService.list(docEntry);
        return Result.success(enquiryExportDataVO, "success");
    }

    /**
     * @param enquiryExportSaveDTO enquiryExportSaveDTO
     * @return Result
     * @description 保存销售单信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @PatchMapping("/quote")
    @Authentication(sale = true)
    public Result<Boolean> saveExportController(
            @RequestBody EnquiryExportSaveDTO enquiryExportSaveDTO
    ) {
        Boolean res = enquiryQuoteService.save(enquiryExportSaveDTO);
        return Result.success(res);
    }
}
