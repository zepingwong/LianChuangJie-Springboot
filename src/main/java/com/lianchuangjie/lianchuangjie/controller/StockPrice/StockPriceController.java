package com.lianchuangjie.lianchuangjie.controller.StockPrice;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.ReplenishDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.service.QuotationService;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceAlgorithmService;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceService;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    StockPriceAlgorithmService stockPriceAlgorithmService;
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
            @RequestParam(defaultValue = "#{null}", value = "NeedReplenish") String needReplenish,
            @RequestParam(defaultValue = "#{null}", value = "Modify") String modify,
            @RequestParam(defaultValue = "#{null}", value = "NewToday") String newToday,
            @RequestParam(defaultValue = "#{null}", value = "OrderDate") Date orderDate,
            @RequestParam(defaultValue = "#{null}", value = "PriceType") Integer pricingType
    ) {
        StockPriceSearchDTO stockPriceSearchDTO = new StockPriceSearchDTO();
        stockPriceSearchDTO.setPage(page);
        stockPriceSearchDTO.setSize(size);
        stockPriceSearchDTO.setBrand(brand);
        stockPriceSearchDTO.setModle(modle);
        stockPriceSearchDTO.setTypeCode(typeCode);
        stockPriceSearchDTO.setStockDays(stockDays);
        // 没有七天采购报价需要补价
        stockPriceSearchDTO.setNeedReplenish(needReplenish == null ? null : needReplenish.equals("N"));
        stockPriceSearchDTO.setPricingType(pricingType);
        stockPriceSearchDTO.setModify(modify);
        stockPriceSearchDTO.setNewToday(newToday);
        stockPriceSearchDTO.setOrderDate(orderDate);
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
    public Result<List<BrandItemVO>> getBrandListController(
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand
    ) {
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
     * @description 补价
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
        quotationEntity.setUBuyer(SessionUtil.getUser().getUserSign()); // 采购员编号
        quotationEntity.setUStatus("Y");
        Boolean res = quotationService.save(quotationEntity);
        if (res) {
            String response;
            try {
                JSONObject json = new JSONObject();
                json.put("data", replenishDTO);
                response = HttpUtil.jsonPost(address + "model_predict_one_time", null, json);
                System.out.println(response);
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Result.success(res, "Success");
    }

    /**
     * @return Result
     * @description 一键OK
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    @PutMapping("/price")
    @Authentication(buyer = true)
    public Result<Boolean> okAllController(@RequestBody @Valid List<StockPriceOKDTO> list ) {
        stockPriceService.updateALL(list);
        return Result.success(true, "Success");
    }

    /**
     * @return Result
     * @description 算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @PostMapping("/price/calculate")
    @Authentication(buyer = true)
    public Result<Boolean> calculateController(@RequestBody List<StockPriceVO> list) {
        Boolean res = stockPriceAlgorithmService.calculateADayService(list);
        return Result.success(res, "更新成功");
    }
    // 获取提前定价型号列表
    /**
     * @return Result
     * @description 算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @GetMapping("/price/inadvance")
    @Authentication(buyer = true)
    public Result<List<StockPriceVO>> getStockPriceInAdvanceList(@RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        List<StockPriceVO> list = stockPriceService.inAdvanceList(modle);
        return Result.success(list);
    }


    /**
     * @return Result
     * @description 算法调用接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/7/2022
     */
    @GetMapping("/price/recalculate")
    @Authentication(buyer = true)
    public Result<Boolean> recalculateController() {
        Boolean res = stockPriceAlgorithmService.calculateOneDayService("手动更新");
        return Result.success(res, "更新成功");
    }
}
