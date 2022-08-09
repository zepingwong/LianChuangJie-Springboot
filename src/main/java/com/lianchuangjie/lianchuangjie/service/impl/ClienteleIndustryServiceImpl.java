package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.ClienteleIndustryMapper;
import com.lianchuangjie.lianchuangjie.service.ClienteleIndustryService;
import com.lianchuangjie.lianchuangjie.vo.ClienteleIndustryItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClienteleIndustryServiceImpl implements ClienteleIndustryService {
    @Resource
    ClienteleIndustryMapper clienteleIndustryMapper;
    @Override
    public List<ClienteleIndustryItemVO> getParentClienteleIndustryListService(String ParentCode) {
        return clienteleIndustryMapper.queryByParentCode(ParentCode);
    }
}
