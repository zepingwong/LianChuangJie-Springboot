package com.lianchuangjie.lianchuangjie.service.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;

import java.util.List;

public interface CurVatConfService extends IService<CurVatConfEntity> {
    List<CurVatConfVO> list(QueryWrapper<CurVatConfVO> queryWrapper);
    CurVatConfVO getOne(QueryWrapper<CurVatConfVO> queryWrapper);
}
