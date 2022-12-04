package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDictSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomDicService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomHeadDictVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Validated
@RestController
@RequestMapping("/enquiry/setting")
public class BomHeadDictionaryController {
    @Resource
    BomDicService bomDicService;

    @GetMapping("bomdict")
    @Authentication()
    public Result<Page<BomHeadDictVO>> getDictionaryList(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page, // 页码
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size, // 每页显示条数
            @RequestParam(defaultValue = "#{null}", value = "DicKey") String dicKey // 所属key
    ) {
        BomHeadDictSearchDTO bomHeadDictSearchDTO = new BomHeadDictSearchDTO(page, size, dicKey);
        Page<BomHeadDictVO> pages = bomDicService.getList(bomHeadDictSearchDTO);
        return Result.success(pages, "Success");
    }
}
