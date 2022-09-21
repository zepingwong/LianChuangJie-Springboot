package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquiryHotwordsService;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController extends BaseController {
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    EnquiryHotwordsService enquiryHotwordsService;

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
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateStart") Date invalidDateStart,
            @RequestParam(defaultValue = "#{null}", value = "InvalidDateEnd") Date invalidDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateStart") Date createDateStart,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateEnd") Date createDateEnd,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode,
            @RequestParam(defaultValue = "#{null}", value = "State") Integer state
    ) {
        EnquiryMainSearchDTO searchCondition = new EnquiryMainSearchDTO();
        searchCondition.setPage(page);
        searchCondition.setSize(size);
        searchCondition.setCardCode(cardCode);
        searchCondition.setState(state);
        searchCondition.setInvalidDateStart(invalidDateStart);
        searchCondition.setInvalidDateEnd(invalidDateEnd);
        searchCondition.setCreateDateStart(createDateStart);
        searchCondition.setCreateDateEnd(createDateEnd);
        searchCondition.setOwnerCode(SessionUtil.getUserSign());
        Page<EnquiryMainItemVO> pages = enquiryMainService.list(searchCondition);
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

    /**
     * @param docEntry docEntry
     * @return Result
     * @description 获取询价单子表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("/sub")
    @Authentication(sale = true)
    public Result<List<EnquirySubVO>> enquirySubController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        List<EnquirySubVO> list = enquirySubService.list(docEntry);
        return Result.success(list, "Success");
    }

    /**
     * @param enquirySubItemDTOList enquirySubItemDTOList
     * @return Result
     * @description 采购报价保存接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    @PutMapping("/sub")
    @Authentication(sale = true)
    public Result<Boolean> saveEnquirySubController(@RequestBody List<EnquirySaveItemDTO> enquirySubItemDTOList) {
        return Result.success(enquirySubService.save(enquirySubItemDTOList), "保存成功");
    }

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
    public Result<Boolean> requote(
            @RequestBody EnquiryReQuoteDTO enquiryReQuoteDTO
    ) {

        return null;
    }
}
