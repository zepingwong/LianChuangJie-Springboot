package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleClientLevelEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleClientLevelMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.ClientLevelService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientLevelServiceImpl extends ServiceImpl<ClienteleClientLevelMapper, ClienteleClientLevelEntity> implements ClientLevelService {
    @Resource
    ClienteleClientLevelMapper clienteleClientLevelMapper;

    @Override
    public List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper) {
        return clienteleClientLevelMapper.selectList(queryWrapper);
    }
}
