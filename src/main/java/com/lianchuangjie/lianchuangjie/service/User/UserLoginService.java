package com.lianchuangjie.lianchuangjie.service.User;

import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.LoginResVO;

public interface UserLoginService {
    /**
     * @description 员工登录
     * @param employee 员工账号、密码
     * @return UserEntity
     */
    LoginResVO employeeLoginService(EmployeeLoginDTO employee);
}
