package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.service.UserService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.LoginResVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("/login")
    public Result<LoginResVO> loginController(
            @RequestBody @Valid EmployeeLoginDTO employee,
            BindingResult result
    ) {
        System.out.println(employee);
        UserEntity user = userService.login(employee);
        LoginResVO userInfo = new LoginResVO();
        BeanUtils.copyProperties(user, userInfo);
        return Result.success(userInfo);
    }
}
