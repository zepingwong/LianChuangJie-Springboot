package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.CompanyLetterheadService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.CompanyLetterheadVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyLetterheadController {
    @Resource
    CompanyLetterheadService companyLetterheadService;

    @GetMapping("/letterhead")
    @Authentication(sale = true)
    public Result<List<CompanyLetterheadVO>> letterheadListController() {
        QueryWrapper<CompanyLetterheadVO> queryWrapper = new QueryWrapper<>();
        return Result.success(companyLetterheadService.list(queryWrapper));
    }
}
