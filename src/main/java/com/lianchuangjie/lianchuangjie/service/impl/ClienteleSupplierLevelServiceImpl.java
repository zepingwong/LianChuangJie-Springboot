package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleSupplierLevelMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleSupplierLevelService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClienteleSupplierLevelServiceImpl extends ServiceImpl<ClienteleSupplierLevelMapper, ClienteleSupplierLevelEntity> implements ClienteleSupplierLevelService {
    @Resource
    ClienteleSupplierLevelMapper clienteleSupplierLevelMapper;

    @Override
    public List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper) {
        return clienteleSupplierLevelMapper.selectList(queryWrapper);
    }
}
