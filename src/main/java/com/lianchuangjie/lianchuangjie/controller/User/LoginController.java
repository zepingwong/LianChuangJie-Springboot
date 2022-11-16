package com.lianchuangjie.lianchuangjie.controller.User;

import com.lianchuangjie.lianchuangjie.dto.User.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.service.User.UserLoginService;
import com.lianchuangjie.lianchuangjie.service.User.UserLogoutService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.User.LoginResVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class LoginController {
    @Resource
    UserLoginService userLoginService;
    @Resource
    UserLogoutService userLogoutService;
    /**
     * @param employee employee
     * @return Result
     * @description 员工登录接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/1/2022
     */
    @PostMapping("/login/employee")
    public Result<LoginResVO> loginController(HttpServletRequest request, @RequestBody @Valid EmployeeLoginDTO employee) {
        LoginResVO loginResVO = userLoginService.employeeLoginService(employee, request);
        return Result.success(loginResVO);
    }

    /**
     * @param request request
     * @return Result
     * @description 用户登出接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 7/26/2022
     */
    @GetMapping("logout")
    public Result<Boolean> logoutController(HttpServletRequest request) {
        Boolean res = userLogoutService.logoutService(request);
        return Result.success(res, "成功");
    }
}
