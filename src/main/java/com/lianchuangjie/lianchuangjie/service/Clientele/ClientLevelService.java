package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleClientLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;

import java.util.List;

public interface ClientLevelService extends IService<ClienteleClientLevelEntity> {
    List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
