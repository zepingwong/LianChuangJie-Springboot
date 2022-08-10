package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleSupplierMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleSupplierService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.ClienteleInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClienteleSupplierServiceImpl extends ServiceImpl<ClienteleSupplierMapper, ClienteleEntity> implements ClienteleSupplierService {
    @Resource
    ClienteleSupplierMapper clienteleSupplierMapper;

    @Override
    public List<ClienteleItemVO> list(String CardName) {
        return clienteleSupplierMapper.selectList(CardName, SessionUtil.getUserSign());
    }

    @Override
    public ClienteleInfoVO getOne(String CardCode) {
        return clienteleSupplierMapper.selectOne(CardCode, SessionUtil.getUserSign());
    }
}
