package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.VatGroupService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Result<List<VatGroupVO>> getVatGroupListController() {
        List<VatGroupVO> list = vatGroupService.list();
        return Result.success(list, "Success");
    }
}
