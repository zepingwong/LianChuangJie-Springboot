package com.lianchuangjie.lianchuangjie.controller.VatCur;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatCurConfEntity;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.service.VatCurConfService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.VatCurConfVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vat")
public class VatCurController {
    @Resource
    VatCurConfService vatCurConfService;
    @GetMapping("/config")
    @Authentication(buyer = true, sale = true)
    public Result<List<VatCurConfVO>> getVatConfigListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String type
    ) {
        QueryWrapper<VatCurConfVO> queryWrapper = new QueryWrapper<>();
        if (type != null) {
            queryWrapper.eq(SqlHelper.table(VatGroupEntity.class).getTableName() + ".Type", type);
        }
        List<VatCurConfVO> list = vatCurConfService.list(queryWrapper);
        return Result.success(list, "Success");
    }

    @GetMapping("/config/{docEntry}")
    @Authentication(buyer = true, sale = true)
    public Result<VatCurConfVO> getVatConfigMainController(
            @PathVariable Long docEntry
    ) {
        QueryWrapper<VatCurConfVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SqlHelper.table(VatCurConfEntity.class).getTableName() + ".DocEntry", docEntry);
        VatCurConfVO vatCurConf = vatCurConfService.getOne(queryWrapper);
        return Result.success(vatCurConf, "Success");
    }
}
