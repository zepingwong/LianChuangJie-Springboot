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
public class CurVatController {
    @Resource
    CurVatConfService curVatConfService;

    @GetMapping("/config")
    @Authentication(buyer = true, sale = true, saleAssist = true)
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
        // ????????????????????????????????????
        CurVatError.DUPLICATION.assertIsTrue(curVatConfService.count(queryWrapper) > 0);
        boolean res = curVatConfService.save(curVatConfEntity);
        // ??????????????????
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
        // ????????????????????????????????????
        CurVatError.DUPLICATION.assertIsTrue(curVatConfService.count(queryWrapper) > 0);

        CurVatConfEntity curVatConfEntity = curVatConfService.getById(curVatEditDTO.getDocEntry());
        // ???????????????????????????
        CurVatError.IS_NULL.assertNotNull(curVatConfEntity);
        BeanUtils.copyProperties(curVatEditDTO, curVatConfEntity);
        boolean res = curVatConfService.updateById(curVatConfEntity);
        // ??????????????????
        CurVatError.SAVE_ERROR.assertIsFalse(res);
        CurVatConfVO curVatConfVO = new CurVatConfVO();
        BeanUtils.copyProperties(curVatConfEntity, curVatConfVO);
        return Result.success(curVatConfVO, "Success");
    }

    @GetMapping("/config/{docEntry}")
    @Authentication(buyer = true, sale = true, saleAssist = true)
    public Result<CurVatConfVO> getVatConfigMainController(
            @PathVariable Long docEntry
    ) {
        QueryWrapper<CurVatConfVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SqlHelper.table(CurVatConfEntity.class).getTableName() + ".DocEntry", docEntry);
        CurVatConfVO vatCurConf = curVatConfService.getOne(queryWrapper);
        return Result.success(vatCurConf, "Success");
    }

    @DeleteMapping("/config/{docEntry}")
    @Authentication()
    public Result<Boolean> deleteCurVatController(
            @PathVariable Long docEntry
    ) {
        CurVatConfEntity curVatConfEntity = curVatConfService.getById(docEntry);
        // ???????????????????????????
        CurVatError.IS_NULL.assertNotNull(curVatConfEntity);
        if (Objects.equals(curVatConfEntity.getIsDeleted(), "Y")) {
            // ??????
            curVatConfEntity.setIsDeleted("N");
        } else {
            // ??????
            curVatConfEntity.setIsDeleted("Y");
        }
        boolean res = curVatConfService.updateById(curVatConfEntity);
        // ??????????????????
        CurVatError.SAVE_ERROR.assertIsFalse(res);
        return Result.success(res, "Success");
    }
}
