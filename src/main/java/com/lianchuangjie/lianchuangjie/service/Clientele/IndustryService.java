package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleIndustryVO;

import java.util.List;

public interface IndustryService extends IService<ClienteleIndustryEntity> {
    List<ClienteleIndustryVO> list(QueryWrapper<ClienteleIndustryVO> queryWrapper);
}
