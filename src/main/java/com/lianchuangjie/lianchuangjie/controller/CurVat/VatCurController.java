package com.lianchuangjie.lianchuangjie.controller.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.service.CurVat.CurVatConfService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/curvat")
public class VatCurController {
    @Resource
    CurVatConfService curVatConfService;
    @GetMapping("/config")
    @Authentication(buyer = true, sale = true)
    public Result<List<CurVatConfVO>> getVatConfigListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String type
    ) {
        QueryWrapper<CurVatConfVO> queryWrapper = new QueryWrapper<>();
        if (type != null) {
            queryWrapper.eq(SqlHelper.table(VatGroupEntity.class).getTableName() + ".Type", type);
        }
        List<CurVatConfVO> list = curVatConfService.list(queryWrapper);
        return Result.success(list, "Success");
    }

    @GetMapping("/config/{docEntry}")
    @Authentication(buyer = true, sale = true)
    public Result<CurVatConfVO> getVatConfigMainController(
            @PathVariable Long docEntry
    ) {
        QueryWrapper<CurVatConfVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SqlHelper.table(CurVatConfEntity.class).getTableName() + ".DocEntry", docEntry);
        CurVatConfVO vatCurConf = curVatConfService.getOne(queryWrapper);
        return Result.success(vatCurConf, "Success");
    }
}
