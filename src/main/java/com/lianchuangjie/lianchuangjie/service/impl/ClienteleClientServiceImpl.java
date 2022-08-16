package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleClientMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleClientService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.ClienteleClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleClientServiceImpl extends ServiceImpl<ClienteleClientMapper, ClienteleEntity> implements ClienteleClientService {
    @Resource
    ClienteleClientMapper clienteleClientMapper;
    @Override
    public List<ClienteleItemVO> list(String CardName) {
        return clienteleClientMapper.selectList(CardName, SessionUtil.getUserSign());
    }

    @Override
    public ClienteleClientInfoVO getOne(String CardCode) {
        return clienteleClientMapper.selectOne(CardCode, SessionUtil.getUserSign());
    }
}
