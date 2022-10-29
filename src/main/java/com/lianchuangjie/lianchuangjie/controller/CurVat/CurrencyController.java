package com.lianchuangjie.lianchuangjie.controller.CurVat;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurrencyEntity;
import com.lianchuangjie.lianchuangjie.service.CurVat.CurrencyService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/curvat")
public class CurrencyController {
    @Resource
    CurrencyService currencyService;

    @GetMapping("/currency")
    @Authentication() // 只有admin有权限
    public Result<List<CurrencyEntity>> getCurrencyListController() {
        return Result.success(currencyService.list(), "Success");
    }
}
