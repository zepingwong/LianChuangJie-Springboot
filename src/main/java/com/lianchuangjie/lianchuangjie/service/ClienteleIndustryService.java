package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleIndustryItemVO;

import java.util.List;

public interface ClienteleIndustryService extends IService<ClienteleIndustryEntity> {
    List<ClienteleIndustryItemVO> list(QueryWrapper<ClienteleIndustryItemVO> queryWrapper);
}
