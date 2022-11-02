package com.lianchuangjie.lianchuangjie.controller.Common;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Resource
    BrandService brandService;

    /**
     * 获取采购负责的品牌
     * @param ownerCode 采购员编号
     * @return List<BrandItemVO>
     */
    @GetMapping("owner")
    @Authentication(buyer = true)
    public Result<List<BrandItemVO>> getBuyersBrandController(
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode
    ) {
        if (ownerCode == null) ownerCode = SessionUtil.getUser().getUserSign();
        List<BrandItemVO> list = brandService.list(ownerCode);
        return Result.success(list, "success");
    }

    @GetMapping("/suggestion")
    @Authentication(buyer = true, sale = true)
    public Result<List<BrandItemVO>> getBrandSuggestionController(
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand
    ) {
        List<BrandItemVO> list = brandService.containList(brand);
        return Result.success(list, "Success");
    }
}
