package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryHotwordsService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryHotwordsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 热搜词
 */

@RestController
@RequestMapping("/enquiry")
public class EnquiryHotwordsController {
    @Resource
    EnquiryHotwordsService enquiryHotwordsService;
    /**
     * @return Result 排名前两个的热搜词
     * @description 查询热搜词
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("/hotwords")
    @Authentication(sale = true)
    public Result<List<EnquiryHotwordsVO>> getEnquiryHotwords() {
        List<EnquiryHotwordsVO> list = enquiryHotwordsService.getList();
        return Result.success(list);
    }
}
