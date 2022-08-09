package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.ClientMapper;
import com.lianchuangjie.lianchuangjie.service.ClientService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.ClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    ClientMapper clientMapper;
    @Override
    public List<ClienteleItemVO> queryListService(String CardName) {
        return clientMapper.queryByCardName(CardName, SessionUtil.getUserSign());
    }

    @Override
    public ClientInfoVO queryInfoService(String CardCode) {
        return clientMapper.queryByCardCode(CardCode, SessionUtil.getUserSign());
    }
}
