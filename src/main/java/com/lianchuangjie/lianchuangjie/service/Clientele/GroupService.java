package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleGroupVO;

import java.util.List;

public interface GroupService extends IService<ClienteleGroupEntity> {
    List<ClienteleGroupVO> list(QueryWrapper<ClienteleGroupVO> queryWrapper);
}
