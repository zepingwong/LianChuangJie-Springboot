package com.lianchuangjie.lianchuangjie.controller.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.CurVat.VatGroupService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.CurVat.VatGroupVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/curvat")
public class VatGroupController {
    @Resource
    VatGroupService vatGroupService;

    /**
     * @param type 税率类型
     * @return List<VatGroupVO>
     * @description 获取 VatGroup 列表
     */
    @GetMapping("/group")
    @Authentication()
    public Result<List<VatGroupVO>> getVatGroupListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String type
    ) {
        QueryWrapper<VatGroupVO> queryWrapper = new QueryWrapper<>();

        if (type != null) {
            queryWrapper.eq("Type", type);
        }
        List<VatGroupVO> list = vatGroupService.list(queryWrapper);
        return Result.success(list, "Success");
    }

    @GetMapping("/group/{code}")
    @Authentication()
    public Result<VatGroupVO> getVatGroupMainController(
            @PathVariable String code
    ) {
        QueryWrapper<VatGroupVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Code", code);
        VatGroupVO vatGroup = vatGroupService.getOne(queryWrapper);
        return Result.success(vatGroup, "Success");
    }
}
