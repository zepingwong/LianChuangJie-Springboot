package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientele")
public class ClientController {
    @Resource
    ClienteleClientService clienteleClientService;
    @Resource
    ClienteleSupplierService clienteleSupplierService;
    @Resource
    ClienteleClientLevelService clienteleClientLevelService;
    @Resource
    ClienteleSupplierLevelService clienteleSupplierLevelService;
    @Resource
    ClienteleGroupService clienteleGroupService;
    @Resource
    ClienteleRegionService clienteleRegionService;
    @Resource
    ClienteleIndustryService clienteleIndustryService;

    @GetMapping("/client")
    @Authentication(sale = true)
    public Result<List<ClienteleItemVO>> getClientListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleItemVO> list = clienteleClientService.list(CardName);
        return Result.success(list, "success");
    }

    @GetMapping("/client/{CardCode}")
    @Authentication(sale = true)
    public Result<ClienteleInfoVO> getClientInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleInfoVO clienteleInfoVO = clienteleClientService.getOne(CardCode);
        return Result.success(clienteleInfoVO, "success");
    }

    @GetMapping("/supplier")
    @Authentication(buyer = true)
    public Result<List<ClienteleItemVO>> getSupplierListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleItemVO> list = clienteleSupplierService.list(CardName);
        return Result.success(list, "success");
    }

    @GetMapping("/supplier/{CardCode}")
    @Authentication(buyer = true)
    public Result<ClienteleInfoVO> getSupplierInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleInfoVO clienteleInfoVO = clienteleSupplierService.getOne(CardCode);
        return Result.success(clienteleInfoVO, "success");
    }

    /**
     * @param Type 业务合作伙伴类型
     * @return List<ClienteleGroupItemVO>
     * @description 获取业务合作伙伴性质列表接口
     */
    @GetMapping("/group")
    @Authentication(buyer = true, sale = true)
    public Result<List<ClienteleGroupItemVO>> getClienteleGroupController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<ClienteleGroupItemVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Type", Type);
        List<ClienteleGroupItemVO> list = clienteleGroupService.list(queryWrapper);
        return Result.success(list, "success");
    }

    /**
     * @return List<ClienteleRegion>
     * @description 获取一级业务合作伙伴地区列表
     */
    @GetMapping("/parentregion")
    @Authentication(buyer = true, sale = true)
    Result<List<ClienteleRegionItemVO>> getParentRegionController() {
        QueryWrapper<ClienteleRegionItemVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ParentCode", 0);
        List<ClienteleRegionItemVO> list = clienteleRegionService.list(queryWrapper);
        return Result.success(list, "success");
    }

    /**
     * @return List<ClienteleIndustry>
     * @description 获得业务合作伙伴行业领域列表接口
     */
    @GetMapping("/industry")
    @Authentication(buyer = true, sale = true)
    Result<List<ClienteleIndustryItemVO>> getClienteleIndustryController() {
        QueryWrapper<ClienteleIndustryItemVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ParentCode", "0");
        List<ClienteleIndustryItemVO> list = clienteleIndustryService.list(queryWrapper);
        return Result.success(list, "success");
    }

    @GetMapping("/level")
    @Authentication(buyer = true, sale = true)
    public Result<List<ClienteleLevelItemVO>> getClienteleLevelController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<ClienteleLevelItemVO> queryWrapper = new QueryWrapper<>();
        List<ClienteleLevelItemVO> list = new ArrayList<>();
        if (Objects.equals(Type, "C")) {
            list = clienteleClientLevelService.list(queryWrapper);
        } else if (Objects.equals(Type, "S")) {
            list = clienteleSupplierLevelService.list(queryWrapper);
        }
        return Result.success(list, "success");
    }
}
