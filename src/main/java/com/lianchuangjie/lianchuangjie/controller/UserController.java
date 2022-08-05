package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.po.User;
import com.lianchuangjie.lianchuangjie.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public Boolean loginController(@RequestBody User user) {
        userService.login(user);
        return true;
    }
}
