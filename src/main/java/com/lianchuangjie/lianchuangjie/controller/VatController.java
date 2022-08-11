package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.VatCurConfEntity;
import com.lianchuangjie.lianchuangjie.entity.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.service.VatCurConfService;
import com.lianchuangjie.lianchuangjie.service.VatGroupService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.VatCurConfVO;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vat")
public class VatController {
    @Resource
    VatGroupService vatGroupService;
    @Resource
    VatCurConfService vatCurConfService;

    /**
     * @param Type 税率类型
     * @return List<VatGroupVO>
     * @description 获取 VatGroup 列表
     */
    @GetMapping("/group")
    @Authentication(buyer = true, sale = true)
    public Result<List<VatGroupVO>> getVatGroupListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<VatGroupVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Type", Type);
        List<VatGroupVO> list = vatGroupService.list(queryWrapper);
        return Result.success(list, "Success");
    }

    @GetMapping("/group/{code}")
    public Result<VatGroupVO> getVatGroupMainController(
            @PathVariable String code
    ) {
        QueryWrapper<VatGroupVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Code", code);
        VatGroupVO vatGroup = vatGroupService.getOne(queryWrapper);
        return Result.success(vatGroup, "Success");
    }

    @GetMapping("/config")
    @Authentication(buyer = true, sale = true)
    public Result<List<VatCurConfVO>> getVatConfigListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<VatCurConfVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SqlHelper.table(VatGroupEntity.class).getTableName() + ".Type", Type);
        List<VatCurConfVO> list = vatCurConfService.list(queryWrapper);
        return Result.success(list, "Success");
    }

    @GetMapping("/config/{docEntry}")
    @Authentication(buyer = true, sale = true)
    public Result<VatCurConfVO> getVatConfigMainController(
            @PathVariable Long docEntry
    ) {
        QueryWrapper<VatCurConfVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SqlHelper.table(VatCurConfEntity.class).getTableName() + ".DocEntry", docEntry);
        VatCurConfVO vatCurConf = vatCurConfService.getOne(queryWrapper);
        return Result.success(vatCurConf, "Success");
    }
}
