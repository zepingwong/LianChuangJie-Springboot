package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockList.SupplierInfoDTO;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListService;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListUploadService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListController extends BaseController {
    @Resource
    StockListUploadService stockListUploadService;
    @Resource
    StockListService stockListService;

    /**
     * @param file     file
     * @param cardCode cardCode
     * @return Result
     * @description 上传库存清单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/20/2022
     */
    @PostMapping("/list/upload/{cardCode}/{currency}/{vatGroup}")
    @Authentication(sale = true)
    public Result<BomUploadResVO> uploadBomController(
            @RequestParam("files") MultipartFile file,
            @PathVariable String cardCode,
            @PathVariable String currency,
            @PathVariable String vatGroup
    ) {
        // 供应商编号不能为空
        ResponseEnum.ISNULL.assertNotNull(cardCode);
        SupplierInfoDTO supplierInfoDTO = new SupplierInfoDTO(
                currency,
                vatGroup,
                cardCode
        );
        stockListUploadService.upload(file, supplierInfoDTO);
        return Result.success(null);
    }

    /**
     * @param modle modle
     * @return Result
     * @description 获取价格趋势
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/23/2022
     */
    @GetMapping("/list/ModlePrice")
    @Authentication(buyer = true)
    public Result<List<BigDecimal>> getModlePrice(
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle
    ) {
        List<BigDecimal> purchasePriceList = stockListService.purchasePriceList(modle);
        return Result.success(purchasePriceList, "Success");
    }
}
