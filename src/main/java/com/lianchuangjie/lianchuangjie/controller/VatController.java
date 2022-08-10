package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.VatGroupService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vat")
public class VatController {
    @Resource
    VatGroupService vatGroupService;

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
}
