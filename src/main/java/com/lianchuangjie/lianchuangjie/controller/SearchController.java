package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.service.BomQueryService;
import com.lianchuangjie.lianchuangjie.service.BomQuerySaveService;
import com.lianchuangjie.lianchuangjie.service.EnquiryBuyerService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search")
public class SearchController {
    @Resource
    BomQueryService bomQueryService;
    @Resource
    EnquiryBuyerService enquiryBuyerService;
    @Resource
    BomQuerySaveService bomQuerySaveService;
    /**
     * bom单批量询价
     * @param docEntry 单据编号
     * @return bom单查询结果
     */
    @GetMapping("bomQuery")
    @Authentication(sale = true)
    public Result<BomQueryResVO> bomQueryController(
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry
    ) {
        try {
            BomQueryResVO result = bomQueryService.queryService(docEntry);
            return Result.success(result, "Success");
        } catch (Exception e) {
            log.error("查询失败");
            e.printStackTrace();
            throw new BaseException(500, "查询失败！" + e.getMessage());
        }
    }

    /**
     * 根据品牌查询采购人员
     * @param brand 品牌
     * @return buyers
     */
    @GetMapping("buyer")
    @Authentication(sale = true)
    public Result<List<EnquiryBuyerItemVO>> getPurchaserController(
            @RequestParam(name = "Brand", defaultValue = "#{null}") String brand,
            @RequestParam(name = "ECCN", defaultValue = "#{null}") String eccn,
            @RequestParam(name = "TotalPrice", defaultValue = "#{null}") BigDecimal totalPrice,
            @RequestParam(name = "SlpCode", defaultValue = "#{null}") Long slpCode,
            @RequestParam(name = "DeptCode", defaultValue = "#{null}") String deptCode
    ) {
        EnquiryBuyerSearchDTO enquiryBuyerSearchDTO = new EnquiryBuyerSearchDTO();
        enquiryBuyerSearchDTO.setBrand(brand);
        enquiryBuyerSearchDTO.setSlpCode(slpCode);
        enquiryBuyerSearchDTO.setDeptCode(deptCode);
        enquiryBuyerSearchDTO.setEccn(eccn);
        enquiryBuyerSearchDTO.setStartTotal(totalPrice);
        List<EnquiryBuyerItemVO> list = enquiryBuyerService.list(enquiryBuyerSearchDTO);
        return Result.success(list, "Success");
    }

    @PostMapping("saveQuery")
    @Authentication(sale = true)
    public Result<Boolean> saveQueryController(
            @RequestBody BomQuerySaveDTO bomQuerySaveDTO
    ) {
        Boolean res = bomQuerySaveService.save(bomQuerySaveDTO);
        return Result.success(res, "Success");
    }
}