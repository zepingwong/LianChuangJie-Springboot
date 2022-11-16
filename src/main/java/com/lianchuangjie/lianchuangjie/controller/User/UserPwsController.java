package com.lianchuangjie.lianchuangjie.controller.User;

import com.lianchuangjie.lianchuangjie.dto.User.UserPasswordDTO;
import com.lianchuangjie.lianchuangjie.service.User.UserPasswordService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户密码接口
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserPwsController {
    @Resource
    UserPasswordService userPasswordService;
    @PatchMapping("/password")
    public Result<Boolean> setPasswordController(@RequestBody @Valid UserPasswordDTO userPasswordDTO) {
        Boolean result = userPasswordService.setUserPassword(userPasswordDTO);
        return Result.success(result, "success");
    }

}
