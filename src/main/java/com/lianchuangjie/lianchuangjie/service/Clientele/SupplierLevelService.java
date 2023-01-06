package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleLevelItemVO;

import java.util.List;

public interface SupplierLevelService extends IService<ClienteleSupplierLevelEntity> {
    List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
