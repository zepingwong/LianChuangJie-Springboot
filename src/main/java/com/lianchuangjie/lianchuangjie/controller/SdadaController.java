package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.SdadaSearchDTO;
import com.lianchuangjie.lianchuangjie.service.SdadaService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sdada")
public class SdadaController {
    @Resource
    SdadaService sdadaService;
    @GetMapping("/list")
    public Result<Page<SdadaVO>> getSdadaList(
            @RequestParam(defaultValue = "#{null}", value = "sno") String sno,
            @RequestParam(defaultValue = "#{null}", value = "QuoBrand") String quoBrand
    ) {
        SdadaSearchDTO sdadaSearchDTO = new SdadaSearchDTO();
        sdadaSearchDTO.setSno(sno);
        sdadaSearchDTO.setQuoBrand(quoBrand);
        Page<SdadaVO> page = sdadaService.list(sdadaSearchDTO);
        return Result.success(page, "Success");
    }
}
