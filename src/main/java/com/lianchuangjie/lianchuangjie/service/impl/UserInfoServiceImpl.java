package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.UserInfoService;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserInfoService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserInfoVO getOne(QueryWrapper<UserInfoVO> queryWrapper) {
        return userMapper.getInfo(queryWrapper);
    }
}
