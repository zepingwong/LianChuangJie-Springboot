package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.UserPasswordDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
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
        UserEntity user = userMapper.selectById(SessionUtil.getUser().getUserSign());
        Boolean match = SecurityUtil.matchesPassword(userPasswordDTO.getOldPassword(), user.getUPasswordWeb());
        ResponseEnum.PASSWORD_ERROR.assertIsFalse(match, "原密码错误"); // 原密码错误
        ResponseEnum.FAILURE.assertNotEqual(userPasswordDTO.getConfirmPassword(), userPasswordDTO.getNewPassword()); // 两次密码不一致
        match = SecurityUtil.matchesPassword(userPasswordDTO.getNewPassword(), user.getUPasswordWeb());
        ResponseEnum.PASSWORD_ERROR.assertIsTrue(match, "密码未修改"); // 密码未修改
        user.setUPasswordWeb(SecurityUtil.encodePassword(userPasswordDTO.getNewPassword()));
        return userMapper.updateById(user) == 1;
    }
}
