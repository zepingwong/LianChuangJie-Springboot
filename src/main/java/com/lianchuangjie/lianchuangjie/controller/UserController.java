package com.lianchuangjie.lianchuangjie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.service.UserLoginService;
import com.lianchuangjie.lianchuangjie.service.UserInfoService;
import com.lianchuangjie.lianchuangjie.service.UserLogoutService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.LoginResVO;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Resource
    UserLoginService userLoginService;
    @Resource
    UserLogoutService userLogoutService;
    @Resource
    UserInfoService userInfoService;

    /**
     * @param employee 工号、密码
     * @param request  http 请求
     * @return LoginResVO
     * @description 员工登录接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     */
    @PostMapping("/login/employee")
    public Result<LoginResVO> loginController(@RequestBody @Valid EmployeeLoginDTO employee, HttpServletRequest request) {
        UserEntity user = userLoginService.employeeLoginService(employee);
        LoginResVO loginRes = new LoginResVO();
        UserInfoVO userInfo = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfo);
        loginRes.setInfo(userInfo);
        // 登录成功
        SessionUtil.setSession(request, "User", user);
        return Result.success(loginRes);
    }

    /**
     * @param request http 请求
     * @return Boolean
     * @description 退出登录
     * @date 2022/7/26
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     */
    @GetMapping("logout")
    public Result<Boolean> logoutController(HttpServletRequest request) {
        Boolean res = userLogoutService.logoutService(request);
        return Result.success(res, "成功");
    }

    /**
     * @param id 用户Id UserCode 或用户编号 UserSign
     * @return user
     * @description 查看用户信息
     * @date 2022/5/26
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     */
    @GetMapping("/{id}")
    public Result<UserInfoVO> getUserInfoController(@PathVariable String id) {
        QueryWrapper<UserInfoVO> queryWrapper = new QueryWrapper<>();
        if (id.matches("\\d+")) {
            // 如果id为数字，则查询用户编号 UserSign
            queryWrapper.eq("UserSign", id);
        } else {
            // 否则查询 UserCode
            queryWrapper.eq("UserCode", id);
        }
        UserInfoVO userInfoVO = userInfoService.getOne(queryWrapper);
        return Result.success(userInfoVO);
    }
}
