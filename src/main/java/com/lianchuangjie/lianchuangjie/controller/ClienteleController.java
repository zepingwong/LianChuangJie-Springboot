package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.Clientele.*;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.*;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleGroupVO;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleIndustryVO;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientele")
public class ClienteleController {
    @Resource
    ClientService clientService;
    @Resource
    SupplierService supplierService;
    @Resource
    ClientLevelService clientLevelService;
    @Resource
    SupplierLevelService supplierLevelService;
    @Resource
    GroupService groupService;
    @Resource
    RegionService regionService;
    @Resource
    IndustryService industryService;

    /**
     * @param CardName CardName
     * @return Result
     * @description 获取客户列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/client")
    @Authentication(sale = true)
    public Result<List<ClienteleVO>> getClientListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleVO> list = clientService.list(CardName);
        return Result.success(list, "success");
    }

    /**
     * @param CardCode CardCode
     * @return Result
     * @description 获取单个客户信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/client/{CardCode}")
    @Authentication(sale = true)
    public Result<ClienteleVO> getClientInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleVO clienteleClientInfoVO = clientService.getOne(CardCode);
        return Result.success(clienteleClientInfoVO, "success");
    }

    /**
     * @param CardName CardName
     * @return Result
     * @description 获取供应商列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/supplier")
    @Authentication(buyer = true)
    public Result<List<ClienteleVO>> getSupplierListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleVO> list = supplierService.list(CardName);
        return Result.success(list, "success");
    }

    /**
     * @param CardCode CardCode
     * @return Result
     * @description 获取单个供应商信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/supplier/{CardCode}")
    @Authentication(buyer = true)
    public Result<ClienteleVO> getSupplierInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleVO clienteleClientInfo = supplierService.getOne(CardCode);
        return Result.success(clienteleClientInfo, "success");
    }

    /**
     * @param Type Type
     * @return Result
     * @description 获取业务合作伙伴性质列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/group")
    @Authentication(buyer = true, sale = true)
    public Result<List<ClienteleGroupVO>> getClienteleGroupController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<ClienteleGroupVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Type", Type);
        List<ClienteleGroupVO> list = groupService.list(queryWrapper);
        return Result.success(list, "success");
    }

    /**
     * @return Result
     * @description 获取一级业务合作伙伴地区列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/parentregion")
    @Authentication(buyer = true, sale = true)
    Result<List<ClienteleRegionItemVO>> getParentRegionController() {
        QueryWrapper<ClienteleRegionItemVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ParentCode", 0);
        List<ClienteleRegionItemVO> list = regionService.list(queryWrapper);
        return Result.success(list, "success");
    }

    /**
     * @return Result
     * @description 获得业务合作伙伴行业领域列表接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/11/2022
     */
    @GetMapping("/industry")
    @Authentication(buyer = true, sale = true)
    Result<List<ClienteleIndustryVO>> getClienteleIndustryController() {
        QueryWrapper<ClienteleIndustryVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ParentCode", "0");
        List<ClienteleIndustryVO> list = industryService.list(queryWrapper);
        return Result.success(list, "success");
    }

    @GetMapping("/level")
    @Authentication(buyer = true, sale = true)
    public Result<List<ClienteleLevelItemVO>> getClienteleLevelController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String Type
    ) {
        QueryWrapper<ClienteleLevelItemVO> queryWrapper = new QueryWrapper<>();
        List<ClienteleLevelItemVO> list = new ArrayList<>();
        if (Objects.equals(Type, "C")) {
            list = clientLevelService.list(queryWrapper);
        } else if (Objects.equals(Type, "S")) {
            list = supplierLevelService.list(queryWrapper);
        }
        return Result.success(list, "success");
    }
}
