package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.service.BomQueryService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@Slf4j
@RestController
@RequestMapping("/search")
public class SearchController {
    @Resource
    BomQueryService bomQueryService;
    /**
     * bom单批量询价
     * @param docEntry 单据编号
     * @return bom单查询结果
     */
    @GetMapping("bomQuery")
    @Authentication(sale = true)
    public Result<BomQueryResVO> bomQuery(
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry
    ) {
        try {
            BomQueryResVO result = bomQueryService.queryService(docEntry);
            return Result.success(result);
        } catch (Exception e) {
            log.error("查询失败");
            e.printStackTrace();
            throw new BaseException(500, "查询失败！" + e.getMessage());
        }
    }
}
