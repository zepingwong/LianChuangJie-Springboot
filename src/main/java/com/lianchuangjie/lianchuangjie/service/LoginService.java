package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.entity.UserEntity;

public interface LoginService {
    /**
     * @description 员工登录
     * @param userEntity 员工信息
     * @return UserEntity
     */
    UserEntity employeeLoginService(UserEntity userEntity);
}
