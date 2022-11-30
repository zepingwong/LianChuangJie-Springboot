package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.mapper.Clientele.ClienteleIndustryMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.IndustryService;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleIndustryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class IndustryServiceImpl extends ServiceImpl<ClienteleIndustryMapper, ClienteleIndustryEntity> implements IndustryService {
    @Resource
    ClienteleIndustryMapper clienteleIndustryMapper;
    @Override
    public List<ClienteleIndustryVO> list(QueryWrapper<ClienteleIndustryVO> queryWrapper) {
        return clienteleIndustryMapper.selectList(queryWrapper);
    }
}
