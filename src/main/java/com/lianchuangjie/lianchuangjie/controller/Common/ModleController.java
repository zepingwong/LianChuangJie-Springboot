package com.lianchuangjie.lianchuangjie.controller.Common;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.SdadaService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/modle")
public class ModleController {
    @Resource
    SdadaService sdadaService;
    /**
     * @param modle modle
     * @return Result
     * @description 型号模糊搜索
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("/suggestion")
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<List<SdadaVO>> getSnoSuggestionController(@RequestParam(name = "Modle", defaultValue = "#{null}") String modle) {
        List<SdadaVO> list = sdadaService.containList(modle);
        return Result.success(list, "Success");
    }
    /**
     * @param modle modle
     * @return Result
     * @description 查询关联型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    @GetMapping("related")
    @Authentication(sale = true, buyer = true, saleAssist = true)
    public Result<List<SdadaVO>> getRelatedListController(@RequestParam(name = "Modle", defaultValue = "#{null}") String modle) {
        List<SdadaVO> list = sdadaService.relatedList(modle);
        return Result.success(list, "Success");
    }
}
