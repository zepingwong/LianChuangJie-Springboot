package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.VatCurConfEntity;
import com.lianchuangjie.lianchuangjie.vo.VatCurConfVO;

import java.util.List;

public interface VatCurConfService extends IService<VatCurConfEntity> {
    List<VatCurConfVO> list(QueryWrapper<VatCurConfVO> queryWrapper);
    VatCurConfVO getOne(QueryWrapper<VatCurConfVO> queryWrapper);
}
