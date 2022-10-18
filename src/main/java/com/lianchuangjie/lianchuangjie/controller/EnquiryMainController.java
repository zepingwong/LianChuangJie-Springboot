package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainItemVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/enquiry")
public class EnquiryMainController extends BaseController {
    @Resource
    EnquiryMainService enquiryMainService;

    /**
     * @param page             page 页码
     * @param size             size 每页显示条数
     * @param invalidDateStart invalidDateStart 失效日期开始时间
     * @param invalidDateEnd   invalidDateEnd 失效日期结束时间
     * @param createDateStart  createDateStart 发送日期开始时间
     * @param createDateEnd    createDateEnd 发送日期结束时间
     * @param cardCode         cardCode 询价单位代码
     * @param state            state 处理情况
     * @return Result
     * @description 获取报价单主表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("/main")
    @Authentication(sale = true)
    public Result<Page<EnquiryMainItemVO>> getEnquiryMainListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page, // 页码
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size, // 每页显示条数
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateStart") Date invalidDateStart,
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateEnd") Date invalidDateEnd, // 失效时间范围
            @RequestParam(defaultValue = "#{null}", value = "CreateDateStart") Date createDateStart,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateEnd") Date createDateEnd, // 发送时间范围
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode, // 询价单位代码
            @RequestParam(defaultValue = "#{null}", value = "State") Integer state // 状态
    ) {
        EnquiryMainSearchDTO searchCondition = new EnquiryMainSearchDTO();
        searchCondition.setPage(page);
        searchCondition.setSize(size);
        searchCondition.setCardCode(cardCode);
        searchCondition.setUState(state);
        searchCondition.setInvalidDateStart(invalidDateStart);
        searchCondition.setInvalidDateEnd(invalidDateEnd);
        searchCondition.setCreateDateStart(createDateStart);
        searchCondition.setCreateDateEnd(createDateEnd);
        searchCondition.setOwnerCode(SessionUtil.getUser().getUserSign());
        Page<EnquiryMainItemVO> pages = enquiryMainService.getList(searchCondition);
        return Result.success(pages);
    }

    /**
     * @param docEntry docEntry 询价单编号
     * @return Result
     * @description
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("/main/{docEntry}")
    @Authentication(sale = true)
    public Result<EnquiryMainInfoVO> getEnquiryMainInfoController(@PathVariable Long docEntry) {
        return Result.success(enquiryMainService.getOne(docEntry));
    }
}
