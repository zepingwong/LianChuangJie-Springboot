package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class BrandController {
    @Resource
    BrandService brandService;
    @GetMapping("brand")
    @Authentication(buyer = true)
    public Result<List<BrandItemVO>> getBuyersBrandController(
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode
    ) {
        List<BrandItemVO> list = brandService.list(ownerCode);
        return Result.success(list, "success");
    }
}
