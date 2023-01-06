package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryBuyerService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySearchService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySearchResultVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 询价搜索接口
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/enquiry")
public class EnquirySearchController extends BaseController {
    @Resource
    EnquiryBuyerService enquiryBuyerService;
    @Resource
    EnquirySearchService enquirySearchService;
    /**
     * 根据品牌查询采购人员
     *
     * @param brand 品牌
     * @return buyers
     */
    @GetMapping("buyer")
    @Authentication(sale = true, saleAssist = true)
    public Result<List<EnquiryBuyerItemVO>> getPurchaserController(@RequestParam(name = "Brand", defaultValue = "#{null}") String brand, @RequestParam(name = "ECCN", defaultValue = "#{null}") String eccn, @RequestParam(name = "TotalPrice", defaultValue = "#{null}") BigDecimal totalPrice, @RequestParam(name = "SlpCode", defaultValue = "#{null}") Long slpCode, @RequestParam(name = "DeptCode", defaultValue = "#{null}") String deptCode) {
        EnquiryBuyerSearchDTO enquiryBuyerSearchDTO = new EnquiryBuyerSearchDTO();
        enquiryBuyerSearchDTO.setBrand(brand);
        enquiryBuyerSearchDTO.setSlpCode(slpCode);
        enquiryBuyerSearchDTO.setDeptCode(deptCode);
        enquiryBuyerSearchDTO.setEccn(eccn);
        enquiryBuyerSearchDTO.setStartTotal(totalPrice);
        List<EnquiryBuyerItemVO> list = enquiryBuyerService.list(enquiryBuyerSearchDTO);
        return Result.success(list, "Success");
    }

    /**
     * @param page 页码
     * @param size 每页显示条数
     * @param modle 型号
     * @return Result
     * @description 搜索型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @GetMapping("/search")
    @Authentication(sale = true)
    public Result<Page<EnquirySearchResultVO>> getEnquirySearchResult(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page, // 页码
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size, // 每页显示条数
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        EnquirySearchDTO enquirySearchDTO = new EnquirySearchDTO();
        enquirySearchDTO.setModle(modle);
        enquirySearchDTO.setPage(page);
        enquirySearchDTO.setSize(size);
        Page<EnquirySearchResultVO> res = enquirySearchService.list(enquirySearchDTO);
        return Result.success(res, "success");
    }
}
