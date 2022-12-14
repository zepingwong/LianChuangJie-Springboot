package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSelectDTO;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListExportVO;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListSubController {
    @Resource
    StockListSubService stockListSubService;
    /**
     * @param page     page
     * @param size     size
     * @param docEntry docEntry
     * @return Result
     * @description 获取库存清单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/27/2022
     */
    @GetMapping("/list/{docEntry}")
    @Authentication(buyer = true)
    public Result<Page<StockListSubVO>> getStockListSubListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size,
            @RequestParam(defaultValue = "#{null}", value = "Modle") String modle,
            @RequestParam(defaultValue = "#{null}", value = "Brand") String brand,
            @RequestParam(defaultValue = "#{null}", value = "StockRank") Long stockRank,
            @RequestParam(defaultValue = "#{null}", value = "Price") BigDecimal price,
            @RequestParam(defaultValue = "#{null}", value = "Status") String status,
            @RequestParam(defaultValue = "#{null}", value = "OpenQty") String openQty,
            @RequestParam(defaultValue = "#{null}", value = "SuggestionQty") String suggestionQty,
            @RequestParam(defaultValue = "#{null}", value = "PopularModle") String popularModle,
            @PathVariable Long docEntry
    ) {
        StockListSubSearchDTO stockListSubSearchDTO = new StockListSubSearchDTO(
                page,
                size,
                docEntry,
                modle,
                brand,
                stockRank,
                price,
                status,
                openQty,
                suggestionQty,
                popularModle
        );
        Page<StockListSubVO> pages = stockListSubService.list(stockListSubSearchDTO);
        return Result.success(pages, "Success");
    }

    @PostMapping("/list/select")
    @Authentication(buyer = true)
    public Result<Boolean> stockListSelectController(
            @RequestBody @Valid List<StockListSelectDTO> stockListSelectDTO
    ) {
        Boolean res = stockListSubService.select(stockListSelectDTO);
        return Result.success(res, "Success");
    }

    @PostMapping("/list/unSelect")
    @Authentication(buyer = true)
    public Result<Boolean> stockListUnSelectController(
            @RequestBody @Valid List<StockListSelectDTO> stockListSelectDTO
    ) {
        Boolean res = stockListSubService.unSelect(stockListSelectDTO);
        return Result.success(res, "Success");
    }

    @GetMapping("/list/export")
    @Authentication()
    public void stockListExportController(
            @RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry,
            @RequestParam(defaultValue = "#{null}", value = "ExportType") Integer exportType,
            HttpServletResponse response
    ) {
        try {
            // 获取导出数据
            List<StockListExportVO> exportData = stockListSubService.export(docEntry, exportType);
            // 获取模板
            ClassPathResource classPathResource = new ClassPathResource(File.separator + "templates" + File.separator + "库存清单导出模板.xlsx");
            InputStream inputStream = classPathResource.getInputStream();
            ExcelWriter excelWriter;
            excelWriter = EasyExcel
                    .write(response.getOutputStream())
                    .withTemplate(inputStream)
                    .build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(exportData, fillConfig, writeSheet);
            String fileName = URLEncoder.encode("库存清单导出结果" + new Date(), "UTF-8").replaceAll("\\+", "%20");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            excelWriter.finish();
        } catch (Exception e) {
            e.printStackTrace();
            throw ResponseEnum.DOWNLOAD_ERROR.newException(e.getMessage());
        }
    }
}
