package com.lianchuangjie.lianchuangjie.controller.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSearchDTO;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListMainService;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListUploadService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListMainVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

@Validated
@RestController
@RequestMapping("/stock")
public class StockListController extends BaseController {
    @Resource
    StockListUploadService stockListUploadService;
    @Resource
    StockListMainService stockListMainService;
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

        StockListSearchDTO stockListSearchDTO = new StockListSearchDTO(
                page,
                size,
                cardCode,
                status,
                createDateStart,
                createDateEnd
        );
        Page<StockListMainVO> pages = stockListMainService.list(stockListSearchDTO);
        return Result.success(pages,"Success");
    }

    /**
     * @param file     file
     * @param cardCode cardCode
     * @return Result
     * @description 上传库存清单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/20/2022
     */
    @PostMapping("/list/upload/{cardCode}")
    @Authentication(sale = true)
    public Result<BomUploadResVO> uploadBomController(
            @RequestParam("files") MultipartFile file,
            @PathVariable String cardCode
    ) {
        // 供应商编号不能为空
        ResponseEnum.ISNULL.assertNotNull(cardCode);
        stockListUploadService.upload(file, cardCode);
        return Result.success(null);
    }
}
