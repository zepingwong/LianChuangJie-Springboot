package com.lianchuangjie.lianchuangjie.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.service.EnquiryExportService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquirySubController extends BaseController {
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    EnquiryExportService enquiryExportService;

    /**
     * @param docEntry docEntry
     * @return Result
     * @description 获取询价单子表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/17/2022
     */
    @GetMapping("/sub")
    @Authentication(sale = true)
    public Result<List<EnquirySubVO>> enquirySubController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        List<EnquirySubVO> list = enquirySubService.list(docEntry);
        return Result.success(list, "Success");
    }

    /**
     * @param enquirySubItemDTOList enquirySubItemDTOList
     * @return Result
     * @description 采购报价保存接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    @PutMapping("/sub")
    @Authentication(sale = true)
    public Result<Boolean> saveEnquirySubController(@RequestBody List<EnquirySaveItemDTO> enquirySubItemDTOList) {
        return Result.success(enquirySubService.save(enquirySubItemDTOList), "保存成功");
    }

    /**
     * @description 导出标准报价单接口
     */
    @GetMapping("/export/{docEntry}")
    @Authentication(sale = true)
    public void enquiryExportController(
            @PathVariable Long docEntry,
            HttpServletResponse response
    ) {
        try {
            EnquiryExportDataVO data = enquiryExportService.export(docEntry);
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
