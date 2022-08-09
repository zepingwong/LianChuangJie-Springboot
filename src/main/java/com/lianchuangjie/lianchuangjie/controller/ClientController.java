package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/clientele")
public class ClientController {
    @Resource
    ClientService clientService;
    @Resource
    ClienteleLevelService clienteleLevelService;
    @Resource
    ClienteleGroupService clienteleGroupService;
    @Resource
    ClienteleRegionService clienteleRegionService;
    @Resource
    ClienteleIndustryService clienteleIndustryService;

    @GetMapping("/client")
    @Authentication(sale = true)
    public Result<List<ClienteleItemVO>> getClientListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleItemVO> list = clientService.queryListService(CardName);
        return Result.success(list, "success");
    }

    @GetMapping("/client/{CardCode}")
    public Result<ClientInfoVO> getClientInfoController(
            @PathVariable String CardCode
    ) {
        ClientInfoVO clientInfoVO = clientService.queryInfoService(CardCode);
        return Result.success(clientInfoVO, "success");
    }

    /**
     * @description 获取业务合作伙伴性质列表接口
     * @param Type 业务合作伙伴类型
     * @return List<ClienteleGroupItemVO>
     */
    @GetMapping("/group")
    @Authentication(buyer = true,sale = true)
    public Result<List<ClienteleGroupItemVO>> getClienteleGroupController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ){
        List<ClienteleGroupItemVO> list = clienteleGroupService.getClienteleGroupListService(Type);
        return Result.success(list, "success");
    }
    /**
     * @description 获取一级业务合作伙伴地区列表
     * @return List<ClienteleRegion>
     */
    @GetMapping("/parentregion")
    @Authentication(buyer = true, sale = true)
    Result<List<ClienteleRegionItemVO>> getParentRegionController() {
        List<ClienteleRegionItemVO> list = clienteleRegionService.getParentRegionService(0);
        return Result.success(list, "success");
    }
    /**
     * @description 获得业务合作伙伴行业领域列表接口
     * @return List<ClienteleIndustry>
     */
    @GetMapping("/industry")
    @Authentication(buyer = true,sale = true)
    Result<List<ClienteleIndustryItemVO>> getClienteleIndustryController(){
        List<ClienteleIndustryItemVO> list = clienteleIndustryService.getParentClienteleIndustryListService("0");
        return Result.success(list, "success");
    }
    @GetMapping("/level")
    @Authentication(buyer = true,sale = true)
    public Result<List<?>> getClienteleLevelController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ){
        List<?> list = clienteleLevelService.getClienteleLevelListService(Type);
        return Result.success(list, "success");
    }
}
