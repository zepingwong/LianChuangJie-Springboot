package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryIsOrderedService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryReQuoteService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController extends BaseController {
    @Resource
    EnquiryReQuoteService enquiryReQuoteService;
    @Resource
    EnquiryIsOrderedService enquiryIsOrderedService;

    /**
     * @return Result
     * @description 确认报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/20/2022
     */
    @PostMapping("requote")
    @Authentication(sale = true, saleAssist = true)
    public Result<Boolean> reQuoteController(@RequestBody EnquiryReQuoteDTO enquiryReQuoteDTO) {
        Boolean res = enquiryReQuoteService.handle(enquiryReQuoteDTO);
        return Result.success(res);
    }

    /**
     * @param enquiryIsOrderedDTO enquiryIsOrderedDTO
     * @return Result
     * @description 是否下单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @PatchMapping("isOrdered")
    @Authentication(sale = true, saleAssist = true)
    public Result<Boolean> isOrderedController(@RequestBody EnquiryIsOrderedDTO enquiryIsOrderedDTO) {
        Boolean res = enquiryIsOrderedService.handle(enquiryIsOrderedDTO);
        return Result.success(res);
    }
}
