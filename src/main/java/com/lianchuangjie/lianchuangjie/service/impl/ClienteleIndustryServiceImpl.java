package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleIndustryMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleIndustryService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleIndustryItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleIndustryServiceImpl extends ServiceImpl<ClienteleIndustryMapper, ClienteleIndustryEntity> implements ClienteleIndustryService {
    @Resource
    ClienteleIndustryMapper clienteleIndustryMapper;
    @Override
    public List<ClienteleIndustryItemVO> list(QueryWrapper<ClienteleIndustryItemVO> queryWrapper) {
        return clienteleIndustryMapper.selectList(queryWrapper);
    }
}
