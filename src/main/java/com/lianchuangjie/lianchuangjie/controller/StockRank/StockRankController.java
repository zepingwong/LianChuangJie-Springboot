package com.lianchuangjie.lianchuangjie.controller.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Validated
@RequestMapping("/stock")
public class StockRankController {
    @Resource
    StockRankService stockRankService;
    @GetMapping("/rank")
    @Authentication(buyer = true)
    public Result<Page<StockRankVO>> getStockRankList(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size
    ) {
        StockRankSearchDTO stockRankSearchDTO = new StockRankSearchDTO();
        stockRankSearchDTO.setPage(page);
        stockRankSearchDTO.setSize(size);
        Page<StockRankVO> pages = stockRankService.list(stockRankSearchDTO);
        return Result.success(pages, "Success");
    }
}
