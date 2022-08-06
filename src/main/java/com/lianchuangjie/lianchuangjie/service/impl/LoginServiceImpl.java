package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    UserMapper userMapper;
    @Override
    public UserEntity employeeLoginService(UserEntity userEntity) {
        // UserCode 不能为空
        String userCode = userEntity.getUserCode();
        ResponseEnum.VALID_ERROR.assertNullOrEmpty(userCode, "登录失败，用户ID不能为空");
        // Password 不能为空
        String password = userEntity.getPassword();
        ResponseEnum.VALID_ERROR.assertNullOrEmpty(password, "登录失败，密码不能为空");
        UserEntity thisUserEntity = userMapper.selectByUserCode(userEntity.getUserCode());
        return thisUserEntity;
    }
}
