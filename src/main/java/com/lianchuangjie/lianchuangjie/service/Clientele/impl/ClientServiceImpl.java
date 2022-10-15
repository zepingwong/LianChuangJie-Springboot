package com.lianchuangjie.lianchuangjie.service.Clientele.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleClientMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.ClientService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClientServiceImpl extends ServiceImpl<ClienteleClientMapper, ClienteleEntity> implements ClientService {
    @Resource
    ClienteleClientMapper clienteleClientMapper;
    @Override
    public List<ClienteleVO> list(String CardName) {
        return clienteleClientMapper.selectList(CardName, SessionUtil.getUserSign());
    }

    @Override
    public ClienteleVO getOne(String CardCode) {
        return clienteleClientMapper.selectOne(CardCode, SessionUtil.getUserSign());
    }
}
