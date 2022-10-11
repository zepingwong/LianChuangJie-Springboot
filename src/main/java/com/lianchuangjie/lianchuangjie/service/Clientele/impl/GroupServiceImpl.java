package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleGroupMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.GroupService;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleGroupVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GroupServiceImpl extends ServiceImpl<ClienteleGroupMapper, ClienteleGroupEntity> implements GroupService {
    @Resource
    ClienteleGroupMapper clienteleGroupMapper;
    @Override
    public List<ClienteleGroupVO> list(QueryWrapper<ClienteleGroupVO> queryWrapper) {
        return clienteleGroupMapper.selectList(queryWrapper);
    }
}
