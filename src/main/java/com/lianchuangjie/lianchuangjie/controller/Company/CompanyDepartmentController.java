package com.lianchuangjie.lianchuangjie.controller.Company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.CompanyDepartmentService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.CompanyDepartmentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyDepartmentController {
    @Resource
    CompanyDepartmentService companyDepartmentService;

    @GetMapping("/department")
    @Authentication(sale = true, buyer = true)
    public Result<List<CompanyDepartmentVO>> letterheadListController() {
        QueryWrapper<CompanyDepartmentVO> queryWrapper = new QueryWrapper<>();
        return Result.success(companyDepartmentService.list(queryWrapper));
    }
}
