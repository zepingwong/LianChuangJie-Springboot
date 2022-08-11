package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;

public interface UserLoginService {
    /**
     * @description 员工登录
     * @param employee 员工账号、密码
     * @return UserEntity
     */
    UserEntity employeeLoginService(EmployeeLoginDTO employee);
}
