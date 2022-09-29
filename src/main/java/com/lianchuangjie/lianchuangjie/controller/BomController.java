package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.BomService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bom")
public class BomController {
    @Resource
    BomService bomService;

    /**
     * @param file BOM单
     * @return BomResult
     * @description BOM单上传解析-并将数据存入 T_BOM 和 T_BOM1 并将 BOM单原件进行存储
     */
    @PostMapping("upload")
    @Authentication(sale = true)
    public Result<BomUploadResVO> uploadBomController(@RequestParam("file") MultipartFile file) {
        BomUploadResVO result = bomService.upload(file);
        return Result.success(result);
    }
    /**
     * @param docEntry docEntry
     * @return Result
     * @description 根据 BOM 单编号批量询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @GetMapping("/query")
    @Authentication(sale = true)
    public Result<BomQueryResVO> queryBomController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        BomQueryResVO result = bomService.list(docEntry);
        return Result.success(result, "Success");
    }
}
