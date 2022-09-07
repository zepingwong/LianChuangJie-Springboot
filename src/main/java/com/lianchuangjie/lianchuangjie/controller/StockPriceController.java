package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKAllDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/stock")
public class StockPriceController extends BaseController {
    @Resource
    StockPriceService stockPriceService;
    @Resource
    BrandService brandService;

    @GetMapping("/price")
    @Authentication(buyer = true)
    public Result<Page<StockPriceVO>> getStockPriceListController(@RequestParam(defaultValue = "#{null}", value = "page") Integer page, @RequestParam(defaultValue = "#{null}", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "TypeCode") String typeCode, @RequestParam(defaultValue = "#{null}", value = "Brand") String brand, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle, @RequestParam(defaultValue = "#{null}", value = "StockDays") Integer stockDays, @RequestParam(defaultValue = "#{null}", value = "NeedReplenish") Boolean needReplenish, @RequestParam(defaultValue = "#{null}", value = "Modify") String modify, @RequestParam(defaultValue = "#{null}", value = "PricingType") Integer pricingType) {
        StockPriceSearchDTO stockPriceSearchDTO = new StockPriceSearchDTO();
        stockPriceSearchDTO.setPage(page);
        stockPriceSearchDTO.setSize(size);
        stockPriceSearchDTO.setBrand(brand);
        stockPriceSearchDTO.setModle(modle);
        stockPriceSearchDTO.setTypeCode(typeCode);
        stockPriceSearchDTO.setStockDays(stockDays);
        stockPriceSearchDTO.setNeedReplenish(needReplenish);
        stockPriceSearchDTO.setPricingType(pricingType);
        stockPriceSearchDTO.setModify(modify);
        Page<StockPriceVO> pages = stockPriceService.list(stockPriceSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @return Result
     * @description 库存定价专员可以查看所有的型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @GetMapping("/price/brand")
    @Authentication(buyer = true)
    public Result<List<BrandItemVO>> getBrandListController(@RequestParam(defaultValue = "#{null}", value = "Brand") String brand) {
        List<BrandItemVO> list = brandService.all(brand);
        return Result.success(list, "Success");
    }

    /**
     * @param stockPriceOKDTO stockPriceOKDTO
     * @return Result
     * @description OK
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @PatchMapping("/price")
    @Authentication(buyer = true)
    public Result<Boolean> okController(@RequestBody @Valid StockPriceOKDTO stockPriceOKDTO) {
        Boolean res = stockPriceService.update(stockPriceOKDTO);
        return Result.success(res, "Success");
    }

    /**
     * @param stockPriceOKAllDTO stockPriceOKAllDTO
     * @return Result
     * @description 一键OK
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @PutMapping("/price")
    @Authentication(buyer = true)
    public Result<Boolean> okAllController(@RequestBody @Valid StockPriceOKAllDTO stockPriceOKAllDTO) {
        Boolean res = stockPriceService.updateALL(stockPriceOKAllDTO);
        return Result.success(res, "Success");
    }

    @GetMapping("/price/calculate")
    @Authentication(buyer = true)
    public Result<String> recalculateController() {
//        RedisUtil redisUtil = new RedisUtil();
//        String status = redisUtil.getHashCache("LianChuangJie", "StockPrice").toString();
//        return Result.success(status);
        return null;
    }

}
