package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController extends BaseController {
    @Resource
    EnquiryReQuoteService enquiryReQuoteService;
    @Resource
    EnquiryHotwordsService enquiryHotwordsService;
    @Resource
    EnquiryIsOrderedService enquiryIsOrderedService;


    /**
     * @return Result 排名前两个的热搜词
     * @description 查询热搜词
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("hotwords")
    @Authentication(sale = true)
    public Result<List<EnquiryHotwordsVO>> getEnquiryHotwords() {
        List<EnquiryHotwordsVO> list = enquiryHotwordsService.getList();
        return Result.success(list);
    }

    /**
     * @return Result
     * @description 确认报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/20/2022
     */
    @PostMapping("requote")
    @Authentication(sale = true)
    public Result<Boolean> requoteController(@RequestBody EnquiryReQuoteDTO enquiryReQuoteDTO) {
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
    @Authentication(sale = true)
    public Result<Boolean> isOrderedController(@RequestBody EnquiryIsOrderedDTO enquiryIsOrderedDTO) {
        Boolean res = enquiryIsOrderedService.handle(enquiryIsOrderedDTO);
        return Result.success(res);
    }
}
