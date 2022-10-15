package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleSupplierMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.SupplierService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierServiceImpl extends ServiceImpl<ClienteleSupplierMapper, ClienteleEntity> implements SupplierService {
    @Resource
    ClienteleSupplierMapper clienteleSupplierMapper;

    @Override
    public List<ClienteleVO> list(String CardName) {
        return clienteleSupplierMapper.selectList(CardName, SessionUtil.getUserSign());
    }

    @Override
    public ClienteleVO getOne(String CardCode) {
        return clienteleSupplierMapper.selectOne(CardCode, SessionUtil.getUserSign());
    }
}
