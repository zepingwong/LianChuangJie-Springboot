package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.SellerService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.SellerVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Resource
    SellerService sellerService;
    @GetMapping("/suggestion")
    @Authentication()
    public Result<List<SellerVO>> getSellerSuggestionList(
            @RequestParam(defaultValue = "#{null}", value = "UserName") String username
    ) {
        List<SellerVO> list = sellerService.containList(username);
        return Result.success(list);
    }
}
