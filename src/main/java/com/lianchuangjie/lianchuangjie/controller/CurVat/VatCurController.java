package com.lianchuangjie.lianchuangjie.controller.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.CurVat.CurVatEditDTO;
import com.lianchuangjie.lianchuangjie.dto.CurVat.CurVatSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.CurVat.CurVatSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.exception.CurVat.CurVatError;
import com.lianchuangjie.lianchuangjie.service.CurVat.CurVatConfService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping("/curvat")
public class VatCurController {
    @Resource
    CurVatConfService curVatConfService;

    @GetMapping("/config")
    @Authentication(buyer = true, sale = true)
    public Result<List<CurVatConfVO>> getVatConfigListController(
            @RequestParam(defaultValue = "#{null}", value = "Type") String type,
            @RequestParam(defaultValue = "#{null}", value = "Currency") String currency,
            @RequestParam(defaultValue = "#{null}", value = "IsDeleted") String isDeleted
    ) {
        CurVatSearchDTO curVatSearchDTO = new CurVatSearchDTO();
        curVatSearchDTO.setCurrency(currency);
        curVatSearchDTO.setType(type);
        curVatSearchDTO.setIsDeleted(isDeleted);
        List<CurVatConfVO> list = curVatConfService.list(curVatSearchDTO);
        return Result.success(list, "Success");
    }

    @PostMapping("/config")
    @Authentication()
    public Result<CurVatConfVO> addCurVatConfController(@RequestBody @Valid CurVatSaveDTO curVatSaveDTO) {
        CurVatConfEntity curVatConfEntity = new CurVatConfEntity();
        curVatConfEntity.setVatGroup(curVatSaveDTO.getVatGroup());
        curVatConfEntity.setCurrency(curVatSaveDTO.getCurrency());
        QueryWrapper<CurVatConfEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Currency", curVatSaveDTO.getCurrency());
        queryWrapper.eq("VatGroup", curVatSaveDTO.getVatGroup());
        // 断言货币类型配置不能重复
        CurVatError.DUPLICATION.assertIsTrue(curVatConfService.count(queryWrapper) > 0);
        boolean res = curVatConfService.save(curVatConfEntity);
        // 断言保存失败
        CurVatError.SAVE_ERROR.assertIsFalse(res);
        CurVatConfVO curVatConfVO = new CurVatConfVO();
        BeanUtils.copyProperties(curVatConfEntity, curVatConfVO);
        return Result.success(curVatConfVO, "Success");
    }

    @PatchMapping("/config")
    @Authentication()
    public Result<CurVatConfVO> ediCurVatConfController(@RequestBody @Valid CurVatEditDTO curVatEditDTO) {
        QueryWrapper<CurVatConfEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Currency", curVatEditDTO.getCurrency());
        queryWrapper.eq("VatGroup", curVatEditDTO.getVatGroup());
        // 断言货币类型配置不能重复
        CurVatError.DUPLICATION.assertIsTrue(curVatConfService.count(queryWrapper) > 0);

        CurVatConfEntity curVatConfEntity = curVatConfService.getById(curVatEditDTO.getDocEntry());
        // 断言配置项是否存在
        CurVatError.IS_NULL.assertNotNull(curVatConfEntity);
        BeanUtils.copyProperties(curVatConfEntity, curVatEditDTO);
        boolean res = curVatConfService.updateById(curVatConfEntity);
        // 断言保存失败
        CurVatError.SAVE_ERROR.assertIsFalse(res);
        CurVatConfVO curVatConfVO = new CurVatConfVO();
        BeanUtils.copyProperties(curVatConfVO, curVatConfEntity);
        return Result.success(curVatConfVO, "Success");
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

    @DeleteMapping("/config/{docEntry}")
    public Result<Boolean> deleteCurVatController(
            @PathVariable Long docEntry
    ) {
        CurVatConfEntity curVatConfEntity = curVatConfService.getById(docEntry);
        // 断言配置项是否存在
        CurVatError.IS_NULL.assertNotNull(curVatConfEntity);
        if (Objects.equals(curVatConfEntity.getIsDeleted(), "Y")) {
            // 作废
            curVatConfEntity.setIsDeleted("N");
        } else {
            // 启用
            curVatConfEntity.setIsDeleted("Y");
        }
        boolean res = curVatConfService.updateById(curVatConfEntity);
        // 断言保存失败
        CurVatError.SAVE_ERROR.assertIsFalse(res);
        return Result.success(res, "Success");
    }
}
