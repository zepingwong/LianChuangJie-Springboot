package com.lianchuangjie.lianchuangjie.controller.VatCur;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.VatGroupService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vat")
public class VatGroupController {
    @Resource
    VatGroupService vatGroupService;

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
}
