package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;
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
    public Result<Page<EnquirySubVO>> enquirySubController(
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size
    ) {
        EnquirySubSearchDTO searchCondition = new EnquirySubSearchDTO();
        searchCondition.setDocEntry(docEntry);
        Long userSign = SessionUtil.getUser().getUserSign();
        searchCondition.setOwnerCode(userSign);
        searchCondition.setPage(page);
        searchCondition.setSize(size);
        searchCondition.setBrand(brand);
        searchCondition.setModle(modle);
        Page<EnquirySubVO> list = enquirySubService.list(searchCondition);
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

    @PatchMapping("/sub")
    @Authentication(sale = true)
    public Result<Boolean> saveOne(@RequestBody EnquirySaveItemDTO enquirySaveItemDTO) {
        enquirySubService.saveOne(enquirySaveItemDTO);
        return null;
    }
}
