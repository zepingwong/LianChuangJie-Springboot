package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListMainSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListMainService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListMainVO;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListMainController extends BaseController {
    @Resource
    StockListMainService stockListMainService;

    /**
     * @param page            page
     * @param size            size
     * @param cardCode        cardCode
     * @param status          status
     * @param createDateStart createDateStart
     * @param createDateEnd   createDateEnd
     * @return Result
     * @description 获取库存清单主表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/23/2022
     */
    @GetMapping("/list")
    @Authentication(buyer = true)
    public Result<Page<StockListMainVO>> getStockListMainListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode,
            @RequestParam(defaultValue = "#{null}", value = "Status") String status,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateStart") Date createDateStart,
            @RequestParam(defaultValue = "#{null}", value = "CreateDateEnd") Date createDateEnd
    ) {

        StockListMainSearchDTO stockListMainSearchDTO = new StockListMainSearchDTO(
                page,
                size,
                cardCode,
                status,
                createDateStart,
                createDateEnd
        );
        Page<StockListMainVO> pages = stockListMainService.list(stockListMainSearchDTO);
        return Result.success(pages, "Success");
    }

    @PatchMapping("/list/complete/{docEntry}")
    @Authentication(buyer = true)
    public Result<Boolean> getStockListSubListController(
            @PathVariable Long docEntry
    ) {
        Boolean res = stockListMainService.complete(docEntry);
        return Result.success(res, "Success");
    }

}
