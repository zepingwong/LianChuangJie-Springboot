package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleSupplierLevelMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.SupplierLevelService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierLevelServiceImpl extends ServiceImpl<ClienteleSupplierLevelMapper, ClienteleSupplierLevelEntity> implements SupplierLevelService {
    @Resource
    ClienteleSupplierLevelMapper clienteleSupplierLevelMapper;

    @Override
    public List<ClienteleLevelItemVO> list(QueryWrapper<ClienteleLevelItemVO> queryWrapper) {
        return clienteleSupplierLevelMapper.selectList(queryWrapper);
    }
}
