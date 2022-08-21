package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.mapper.SingleQueryMapper;
import com.lianchuangjie.lianchuangjie.service.SingleQueryService;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SingleQueryServiceImpl implements SingleQueryService {
    @Resource
    SingleQueryMapper singleQueryMapper;
    @Override
    public BomQueryItemVO query(SingleQueryDTO singleQueryDTO) {
        return singleQueryMapper.selectOne(singleQueryDTO);
    }
}
