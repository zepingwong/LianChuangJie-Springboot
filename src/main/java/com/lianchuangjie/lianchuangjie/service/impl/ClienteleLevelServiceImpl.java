package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.ClienteleLevelMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleLevelService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleLevelServiceImpl implements ClienteleLevelService {
    @Resource
    ClienteleLevelMapper clienteleLevelMapper;
    @Override
    public List<ClienteleLevelItemVO> getClienteleLevelListService(String Type) {
        return clienteleLevelMapper.queryByType(Type);
    }
}
