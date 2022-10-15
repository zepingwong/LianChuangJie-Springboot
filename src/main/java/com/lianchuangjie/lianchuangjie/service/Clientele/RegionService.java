package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;

import java.util.List;

public interface RegionService extends IService<ClienteleRegionEntity> {
    List<ClienteleRegionItemVO> list(QueryWrapper<ClienteleRegionItemVO> queryWrapper);
}
