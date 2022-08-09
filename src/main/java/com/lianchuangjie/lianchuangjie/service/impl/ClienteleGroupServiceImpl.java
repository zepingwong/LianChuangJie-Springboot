package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.ClienteleGroupMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleGroupService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleGroupServiceImpl implements ClienteleGroupService {
    @Resource
    ClienteleGroupMapper clienteleGroupMapper;
    @Override
    public List<ClienteleGroupItemVO> getClienteleGroupListService(String type) {
        return clienteleGroupMapper.queryByType(type);
    }
}
