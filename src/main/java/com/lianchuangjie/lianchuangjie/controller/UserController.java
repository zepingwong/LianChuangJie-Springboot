package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.service.LoginService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.LoginResVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Resource
    LoginService loginService;

    @PostMapping("/login/employee")
    public Result<LoginResVO> loginController(
            @RequestBody @Valid EmployeeLoginDTO employee,
            HttpServletRequest request
    ) {
        UserEntity user = loginService.employeeLoginService(employee);
        LoginResVO userInfo = new LoginResVO();
        BeanUtils.copyProperties(user, userInfo);
        // 登录成功
        SessionUtil.setSession(request, "User", user);
        return Result.success(userInfo);
    }
}
