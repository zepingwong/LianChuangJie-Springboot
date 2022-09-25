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
    public UserEntity getOne(String id) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        if (id.matches("\\d+")) {
            // 如果id为数字，则查询用户编号 UserSign
            queryWrapper.eq("UserSign", id);
        } else {
            // 否则查询 UserCode
            queryWrapper.eq("UserCode", id);
        }
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public UserEntity getOne(Long userSign) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        return userMapper.selectOne(queryWrapper);
    }
}
