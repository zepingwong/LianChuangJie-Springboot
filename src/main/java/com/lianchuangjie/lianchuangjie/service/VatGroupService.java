package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;

import java.util.List;

public interface VatGroupService extends IService<VatGroupEntity> {
    List<VatGroupVO> list(QueryWrapper<VatGroupVO> queryWrapper);
}
