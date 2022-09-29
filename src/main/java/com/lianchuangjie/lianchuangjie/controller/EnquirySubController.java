package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquirySubController extends BaseController {
    @Resource
    EnquirySubService enquirySubService;


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
}
