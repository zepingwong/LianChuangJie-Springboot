package com.lianchuangjie.lianchuangjie.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryExportService;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/enquiry")
public class EnquiryExportController {
    @Resource
    EnquiryExportService enquiryExportService;

    /**
     * @param docEntry docEntry
     * @param response response
     * @description 导出标准报价单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    @GetMapping("/export/{docEntry}")
    @Authentication(sale = true)
    public void enquiryExportController(
            @PathVariable Long docEntry,
            HttpServletResponse response
    ) {
        try {
            EnquiryExportDataVO data = enquiryExportService.list(docEntry);
            //获取模板
            ClassPathResource classPathResource = new ClassPathResource(File.separator + "templates" + File.separator + "标准报价单模板.xlsx");
            InputStream inputStream = classPathResource.getInputStream();
            ExcelWriter excelWriter;
            excelWriter = EasyExcel
                    .write(response.getOutputStream())
                    .withTemplate(inputStream)
                    .build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(data.getEnquiryExportHead(), writeSheet);
            excelWriter.fill(data.getEnquiryExportList(), fillConfig, writeSheet);

            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
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
