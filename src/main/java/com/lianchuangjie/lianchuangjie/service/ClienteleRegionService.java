package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;

import java.util.List;

public interface ClienteleRegionService extends IService<ClienteleRegionEntity> {
    List<ClienteleRegionItemVO> list(QueryWrapper<ClienteleRegionItemVO> queryWrapper);
}
