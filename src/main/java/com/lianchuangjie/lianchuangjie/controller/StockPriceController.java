package com.lianchuangjie.lianchuangjie.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.ReplenishDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKAllDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@Validated
@RequestMapping("/stock")
public class StockPriceController extends BaseController {
    @Resource
    StockPriceService stockPriceService;
    @Resource
    QuotationService quotationService;
    @Resource
    BrandService brandService;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Value("${algorithm_address}")
    private String address;

    @GetMapping("/price")
    @Authentication(buyer = true)
    public Result<Page<StockPriceVO>> getStockPriceListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "TypeCode") String typeCode,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "StockDays") Integer stockDays,
            @RequestParam(defaultValue = "#{null}", value = "NeedReplenish") Boolean needReplenish,
            @RequestParam(defaultValue = "#{null}", value = "Modify") String modify,
            @RequestParam(defaultValue = "#{null}", value = "PricingType") Integer pricingType
    ) {
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
     * @param replenishDTO replenishDTO
     * @return Result
     * @description 一键OK
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @PostMapping("/price")
    @Authentication(buyer = true)
    public Result<Boolean> replenishController(@RequestBody @Valid ReplenishDTO replenishDTO) {
        QuotationEntity quotationEntity = new QuotationEntity();
        BeanUtils.copyProperties(replenishDTO, quotationEntity);
        quotationEntity.setDocEntry(Long.parseLong("0")); // 库存定价来的货源，DocEntry 为 0
        QueryWrapper<QuotationEntity> queryWrapper = new QueryWrapper<>();
        // T_ICIN1.LineNum表示报价次数
        queryWrapper.eq("DocEntry", 0);
        quotationEntity.setLineNum(quotationService.count(queryWrapper) + 1);
        quotationEntity.setUBuyer(SessionUtil.getUserSign()); // 采购员编号
        Boolean res = quotationService.save(quotationEntity);
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
        stockPriceService.updateALL(stockPriceOKAllDTO);
        return Result.success(true, "Success");
    }

    /**
     * @return Result
     * @description 算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @GetMapping("/price/calculate")
    @Authentication(buyer = true)
    public Result<Boolean> recalculateController() {
        String state = stringRedisTemplate.opsForValue().get("StockPrice");
        if (Objects.equals(state, "1")) {
            return Result.error(1, "算法正在运行，请稍后刷新结果");
        } else {
            stringRedisTemplate.opsForValue().set("StockPrice", "1");
            String res;
            try {
                JSONObject json = new JSONObject();
                json.put("data", "111");
                res = HttpUtil.jsonPost(address + "model_predict_a_day", null, json);
                System.out.println(res);
                if (res != null) {
                    stringRedisTemplate.opsForValue().set("StockPrice", "0");
                }
            } catch (IOException e) {
                stringRedisTemplate.opsForValue().set("StockPrice", "0");
                throw new RuntimeException(e);
            }
            return Result.success(true, "更新成功");
        }
    }
}
