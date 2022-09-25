package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.BomQueryMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.QueryService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @Resource
    BomQueryMapper bomQueryMapper;
    @Resource
    UserMapper userMapper;
    
    private void setUserInfo(SingleQueryDTO singleQueryDTO) {
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        UserEntity user = userMapper.selectOne(queryWrapper);
        singleQueryDTO.setSlpCode(userSign);
        singleQueryDTO.setDeptCode(user.getDftDept());
    }

    @Override
    public BomQueryResVO queryBom(Long docEntry) {
        BomQueryResVO bomQueryRes = new BomQueryResVO();
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        UserEntity user = userMapper.selectOne(queryWrapper);
        List<BomQueryItemVO> list = bomQueryMapper.queryBom(docEntry, user.getDftDept(), userSign);
        bomQueryRes.setBomQueryItemList(list);
        bomQueryRes.setTotalSize(list.size());
        return bomQueryRes;
    }

    @Override
    public BomQueryItemVO querySingle(SingleQueryDTO singleQueryDTO) {
        // 当前登录用户
        setUserInfo(singleQueryDTO);
        return bomQueryMapper.querySingle(singleQueryDTO);
    }

    @Override
    public List<BomQueryItemVO> queryRelated(SingleQueryDTO singleQueryDTO) {
        // 当前登录用户
        setUserInfo(singleQueryDTO);
        return bomQueryMapper.queryRelated(singleQueryDTO);
    }
}
