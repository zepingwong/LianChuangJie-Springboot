package com.lianchuangjie.lianchuangjie.controller.StockPrice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceLogSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceLogService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceLogVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Validated
@RequestMapping("/stock/price")
public class StockPriceLogController extends BaseController {
    @Resource
    StockPriceLogService stockPriceLogService;
    @GetMapping("/log")
    public Result<Page<StockPriceLogVO>> getLogList(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "TimeStart") Date timeStart,
            @RequestParam(defaultValue = "#{null}", value = "TimeEnd") Date timeEnd,
            @RequestParam(defaultValue = "#{null}", value = "TriggerType") String triggerType,
            @RequestParam(defaultValue = "#{null}", value = "TriggerName") String triggerName
    ) {
        StockPriceLogSearchDTO stockPriceLogSearchDTO = new StockPriceLogSearchDTO();
        stockPriceLogSearchDTO.setPage(page);
        stockPriceLogSearchDTO.setSize(size);
        stockPriceLogSearchDTO.setTimeStart(timeStart);
        stockPriceLogSearchDTO.setTimeEnd(timeEnd);
        stockPriceLogSearchDTO.setTriggerType(triggerType);
        stockPriceLogSearchDTO.setTriggerName(triggerName);
        Page<StockPriceLogVO> pages  = stockPriceLogService.list(stockPriceLogSearchDTO);
        return Result.success(pages, "Success");
    }
}
