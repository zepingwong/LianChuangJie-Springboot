package com.lianchuangjie.lianchuangjie.service.User;

import com.lianchuangjie.lianchuangjie.dto.User.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.vo.User.LoginResVO;

import javax.servlet.http.HttpServletRequest;

public interface UserLoginService {
    /**
     * @description 员工登录
     * @param employee 员工账号、密码
     * @return UserEntity
     */
    LoginResVO employeeLoginService(EmployeeLoginDTO employee, HttpServletRequest request);
}
