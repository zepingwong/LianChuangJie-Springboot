package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.UserPasswordDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.User.UserPasswordService;
import com.lianchuangjie.lianchuangjie.utils.SecurityUtil;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserPasswordServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserPasswordService {
    @Resource
    UserMapper userMapper;
    @Override
    public Boolean setUserPassword(UserPasswordDTO userPasswordDTO) {
        UserEntity user = SessionUtil.getUser();
        user.setUPasswordWeb(SecurityUtil.encodePassword(userPasswordDTO.getNewPassword()));
        return userMapper.updateById(user) == 1;
    }
}
