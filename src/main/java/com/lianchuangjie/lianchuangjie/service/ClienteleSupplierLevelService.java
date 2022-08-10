package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleClientLevelEntity;
import com.lianchuangjie.lianchuangjie.entity.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;

import java.util.List;

public interface ClienteleSupplierLevelService extends IService<ClienteleSupplierLevelEntity> {
    List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
