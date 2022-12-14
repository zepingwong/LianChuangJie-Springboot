package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomMainSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomMainService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomSubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomUploadResVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomExportVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomMainVO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping("/enquiry/bom")
public class EnquiryBomController extends BaseController {
    @Resource
    BomService bomService;
    @Resource
    BomSubService bomSubService;
    @Resource
    BomMainService bomMainService;


    /**
     * @param file BOM???
     * @return BomResult
     * @description BOM???????????????-?????????????????? T_BOM ??? T_BOM1 ?????? BOM?????????????????????
     */
    @PostMapping("upload")
    @Authentication(sale = true, saleAssist = true)
    public Result<BomUploadResVO> uploadBomController(@RequestParam("file") MultipartFile file) {
        BomUploadResVO result = bomService.upload(file);
        return Result.success(result);
    }
    /**
     * @param enquiryBomUpdateDTO enquiryBomUpdateDTO
     * @return Result
     * @description ??????Bom?????????
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/6/2022
     */
    @PatchMapping("update")
    @Authentication(sale = true, saleAssist = true)
    public Result<Boolean> updateBomController(
            @RequestBody @Valid EnquiryBomUpdateDTO enquiryBomUpdateDTO
    ) {
        Boolean res = bomSubService.updateOne(enquiryBomUpdateDTO);
        return Result.success(res, "Success");
    }

    /**
     * @return ResponseEntity
     * @description ??????Bom?????????
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @GetMapping(value = "download", produces = "application/ms-excel")
    @Authentication(sale = true, saleAssist = true)
    public ResponseEntity<byte[]> downloadTemplate(HttpServletResponse response) throws IOException {
        ClassPathResource resource = new ClassPathResource(File.separator + "templates" + File.separator + "BOM??????-Unibetter.xlsx");
        String fileName = "BOM??????-Unibetter.xlsx";
        try {
            File file = resource.getFile();
            // ??????????????????
            if (file.exists()) {
                HttpHeaders headers = new HttpHeaders();
                //?????????????????????????????????????????????????????????
                String downloadFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
                //??????????????????attachment??????????????????????????????
                headers.setContentDispositionFormData("attachment", downloadFileName);
                //application/octet-stream ??? ???????????????????????????????????????????????????
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                InputStream inputStream = resource.getInputStream();
                byte[] body = new byte[inputStream.available()];
                //noinspection ResultOfMethodCallIgnored
                inputStream.read(body);
                return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
            } else {
                throw ResponseEnum.DOWNLOAD_ERROR.newException("???????????????");
            }
        } catch (IOException e) {
            throw ResponseEnum.DOWNLOAD_ERROR.newException(e.getMessage());
        }
    }

    /**
     * @param page page
     * @param size size
     * @return Result
     * @description Bom???????????????
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/16/2022
     */
    @GetMapping(value = "list")
    @Authentication(sale = true, saleAssist = true)
    public Result<Page<BomMainVO>> getBomMainListController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page, // ??????
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size, // ??????????????????
            @RequestParam(defaultValue = "#{null}", value = "OwnerCode") Long ownerCode, // ???????????????
            @RequestParam(defaultValue = "#{null}", value = "CreateTimeStart") Date createTimeStart,
            @RequestParam(defaultValue = "#{null}", value = "CreateTimeEnd") Date createTimeEnd
    ) {
        BomMainSearchDTO bomMainSearchDTO = new BomMainSearchDTO(page, size, ownerCode, createTimeStart, createTimeEnd);
        Page<BomMainVO> pages = bomMainService.list(bomMainSearchDTO);
        return Result.success(pages, "Success");
    }

    /**
     * @param docEntry docEntry
     * @param response response
     * @description ??????Bom??????????????????
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/20/2022
     */
    @GetMapping("export/{docEntry}")
    @Authentication(sale = true)
    public void bomExportController(
            @PathVariable Long docEntry,
            HttpServletResponse response
    ) {
        try {
            // ??????????????????
            List<BomExportVO> exportData = bomService.export(docEntry);
            // ????????????
            ClassPathResource classPathResource = new ClassPathResource(File.separator + "templates" + File.separator + "Bom????????????.xlsx");
            InputStream inputStream = classPathResource.getInputStream();
            ExcelWriter excelWriter;
            excelWriter = EasyExcel
                    .write(response.getOutputStream())
                    .withTemplate(inputStream)
                    .build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(exportData, fillConfig, writeSheet);
            String fileName = URLEncoder.encode("Bom??????????????????" + new Date(), "UTF-8").replaceAll("\\+", "%20");
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
