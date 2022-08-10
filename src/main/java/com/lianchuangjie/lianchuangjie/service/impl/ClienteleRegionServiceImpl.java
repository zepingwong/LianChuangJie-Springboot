package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleRegionService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleRegionServiceImpl extends ServiceImpl<ClienteleRegionMapper, ClienteleRegionEntity> implements ClienteleRegionService {
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;
    @Override
    public List<ClienteleRegionItemVO> list(QueryWrapper<ClienteleRegionItemVO> queryWrapper) {
        return clienteleRegionMapper.selectList(queryWrapper);
    }
}
