package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;

import java.util.List;

public interface ClienteleGroupService extends IService<ClienteleGroupEntity> {
    List<ClienteleGroupItemVO> list(QueryWrapper<ClienteleGroupItemVO> queryWrapper);
}
