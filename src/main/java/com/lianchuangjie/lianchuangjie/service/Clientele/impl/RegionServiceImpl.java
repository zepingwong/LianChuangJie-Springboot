package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.mapper.Clientele.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.RegionService;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleRegionItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RegionServiceImpl extends ServiceImpl<ClienteleRegionMapper, ClienteleRegionEntity> implements RegionService {
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;
    @Override
    public List<ClienteleRegionItemVO> list(QueryWrapper<ClienteleRegionItemVO> queryWrapper) {
        return clienteleRegionMapper.selectList(queryWrapper);
    }
}
