package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleGroupMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleGroupService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleGroupServiceImpl extends ServiceImpl<ClienteleGroupMapper, ClienteleGroupEntity> implements ClienteleGroupService {
    @Resource
    ClienteleGroupMapper clienteleGroupMapper;
    @Override
    public List<ClienteleGroupItemVO> list(QueryWrapper<ClienteleGroupItemVO> queryWrapper) {
        return clienteleGroupMapper.selectList(queryWrapper);
    }
}
