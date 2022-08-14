package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.service.SellerService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import com.lianchuangjie.lianchuangjie.vo.SellerVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Resource
    BrandService brandService;
    @Resource
    SellerService sellerService;

    /**
     * 获取采购负责的品牌
     * @param ownerCode 采购员编号
     * @return List<BrandItemVO>
     */
    @GetMapping("/brand")
    @Authentication(buyer = true)
    public Result<List<BrandItemVO>> getBuyersBrandController(
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode
    ) {
        List<BrandItemVO> list = brandService.list(ownerCode);
        return Result.success(list, "success");
    }

    @GetMapping("/seller")
    @Authentication(buyer = true)
    public Result<List<SellerVO>> getBuyersSellerController(
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode
    ) {
        List<SellerVO> list = sellerService.list(ownerCode);
        return Result.success(list, "success");
    }
}
