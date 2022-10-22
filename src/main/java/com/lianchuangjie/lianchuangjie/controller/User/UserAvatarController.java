package com.lianchuangjie.lianchuangjie.controller.User;

import com.lianchuangjie.lianchuangjie.service.User.UserAvatarService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserAvatarController {
    @Resource
    UserAvatarService userAvatarService;
    @PostMapping("/avatar")
    public Result<Boolean> uploadAvatarController(@RequestBody String avatar) {
        Boolean res = userAvatarService.upload(avatar);
        return Result.success(res, "success");
    }
}
