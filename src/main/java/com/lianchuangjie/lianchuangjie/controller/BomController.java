package com.lianchuangjie.lianchuangjie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.BomService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Validated
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
    @GetMapping("query")
    @Authentication(sale = true)
    public Result<BomQueryResVO> queryBomController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        BomQueryResVO result = bomService.list(docEntry);
        return Result.success(result, "Success");
    }

    /**
     * @param bomQuerySaveDTO bomQuerySaveDTO
     * @param request         request
     * @return Result
     * @description 保存Bom单解析结果
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @PostMapping("save")
    @Authentication(sale = true)
    public Result<Boolean> saveQueryController(@RequestBody @Valid BomQuerySaveDTO bomQuerySaveDTO, HttpServletRequest request) {
        Object obj = SessionUtil.getSession(request, "User");
        ObjectMapper objectMapper = new ObjectMapper();
        UserEntity user = objectMapper.convertValue(obj, UserEntity.class);
        Boolean res = bomService.save(bomQuerySaveDTO, user);
        return Result.success(res, "Success");
    }

    /**
     * @return ResponseEntity
     * @description 下载Bom单模板
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @GetMapping(value = "/download", produces = "application/ms-excel")
    @Authentication(sale = true)
    public ResponseEntity<byte[]> downloadTemplate(HttpServletResponse response) throws IOException {
        ClassPathResource resource = new ClassPathResource(File.separator + "templates" + File.separator + "BOM样例-Unibetter.xlsx");
        String fileName = "BOM样例-Unibetter.xlsx";
        try {
            File file = resource.getFile();
            // 下载文件路径
            if (file.exists()) {
                HttpHeaders headers = new HttpHeaders();
                //下载显示的文件名，解决中文名称乱码问题
                String downloadFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
                //通知浏览器以attachment（下载方式）打开图片
                headers.setContentDispositionFormData("attachment", downloadFileName);
                //application/octet-stream ： 二进制流数据（最常见的文件下载）。
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                InputStream inputStream = resource.getInputStream();
                byte[] body = new byte[inputStream.available()];
                //noinspection ResultOfMethodCallIgnored
                inputStream.read(body);
                return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
            } else {
                throw ResponseEnum.DOWNLOAD_ERROR.newException("文件不存在");
            }
        } catch (IOException e) {
            throw ResponseEnum.DOWNLOAD_ERROR.newException(e.getMessage());
        }
    }
}
