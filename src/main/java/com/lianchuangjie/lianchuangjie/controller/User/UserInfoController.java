package com.lianchuangjie.lianchuangjie.controller.User;

import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.service.User.UserAvatarService;
import com.lianchuangjie.lianchuangjie.service.User.UserInfoService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.vo.User.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息接口
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;
    @Resource
    UserAvatarService userAvatarService;

    /**
     * @param id 用户Id UserCode 或用户编号 UserSign
     * @return Result
     * @description 查看用户信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 5/26/2022
     */
    @GetMapping("/info/{id}")
    public Result<UserInfoVO> getUserInfoController(@PathVariable String id) {
        UserInfoVO userInfoVO = new UserInfoVO();
        UserEntity user;
        if (id.equals("0") | Integer.parseInt(id) == 0) {
            user = ContextUtil.getUser();
        } else {
            user = userInfoService.getOne(id);
        }
        BeanUtils.copyProperties(user, userInfoVO);
        return Result.success(userInfoVO);
    }

    /**
     * @param avatar avatar
     * @return Result
     * @description 用户上传头像
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/12/2022
     */
    @PostMapping("/info/avatar")
    public Result<Boolean> uploadAvatarController(@RequestBody String avatar) {
        Boolean res = userAvatarService.upload(avatar);
        return Result.success(res, "success");
    }
}
