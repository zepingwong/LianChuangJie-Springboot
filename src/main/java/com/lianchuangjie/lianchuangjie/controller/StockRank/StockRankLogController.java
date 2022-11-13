package com.lianchuangjie.lianchuangjie.controller.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankLogSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankLogService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankLogVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Validated
@RequestMapping("/stock/rank")
public class StockRankLogController extends BaseController {
    @Resource
    StockRankLogService stockRankLogService;
    @GetMapping("/log")
    public Result<Page<StockRankLogVO>> getLogList(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "TimeStart") Date timeStart,
            @RequestParam(defaultValue = "#{null}", value = "TimeEnd") Date timeEnd,
            @RequestParam(defaultValue = "#{null}", value = "TriggerType") String triggerType,
            @RequestParam(defaultValue = "#{null}", value = "TriggerName") String triggerName
    ) {
        StockRankLogSearchDTO stockRankLogSearchDTO = new StockRankLogSearchDTO();
        stockRankLogSearchDTO.setPage(page);
        stockRankLogSearchDTO.setSize(size);
        stockRankLogSearchDTO.setTimeStart(timeStart);
        stockRankLogSearchDTO.setTimeEnd(timeEnd);
        stockRankLogSearchDTO.setTriggerType(triggerType);
        stockRankLogSearchDTO.setTriggerName(triggerName);
        Page<StockRankLogVO> pages  = stockRankLogService.list(stockRankLogSearchDTO);
        return Result.success(pages, "Success");
    }
}
