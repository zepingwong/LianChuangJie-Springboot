package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.BomUploadService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/search")
public class UploadBomController {
    @Resource
    BomUploadService bomUploadService;

    /**
     * @param file BOM单
     * @return BomResult
     * @description BOM单上传解析-并将数据存入 T_BOM 和 T_BOM1 并将 BOM单原件进行存储
     */
    @PostMapping("uploadBom")
    @Authentication(sale = true)
    public Result<BomUploadResVO> uploadBom(@RequestParam("file") MultipartFile file) {
        BomUploadResVO result = bomUploadService.uploadService(file);
        return Result.success(result);
    }
}
