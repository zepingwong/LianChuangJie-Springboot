package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.service.SdadaService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tab")
public class TabSdadaController {
    @Resource
    SdadaService sdadaService;

    /**
     * @param page  page 页码
     * @param size  size 每页显示数量
     * @param modle modle 型号
     * @return Result
     * @description 标准型号-单个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @GetMapping("/sdada")
    @Authentication(sale = true, buyer = true)
    public Result<Page<SdadaVO>> getStandardData(@RequestParam(defaultValue = "1", value = "page") Integer page, @RequestParam(defaultValue = "10", value = "size") Integer size, @RequestParam(defaultValue = "#{null}", value = "Modle") String modle) {
        TabSearchDTO tabSearchDTO = new TabSearchDTO();
        tabSearchDTO.setPage(page);
        tabSearchDTO.setSize(size);
        tabSearchDTO.setModle(modle);
        Page<SdadaVO> res = sdadaService.tabList(tabSearchDTO);
        return Result.success(res);
    }

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Result
     * @description 标准型号-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/19/2022
     */
    @PostMapping("/sdada")
    @Authentication(sale = true, buyer = true)
    public Result<Page<SdadaVO>> getStandardData(@RequestBody TabSearchDTO tabSearchDTO) {
        Page<SdadaVO> res = sdadaService.tabList(tabSearchDTO);
        return Result.success(res);
    }
}
