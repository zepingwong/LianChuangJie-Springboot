package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleRegionService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleRegionServiceImpl implements ClienteleRegionService {
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;
    @Override
    public List<ClienteleRegionItemVO> getParentRegionService(Integer ParentCode) {
        return clienteleRegionMapper.queryByParentCode(ParentCode);
    }
}
