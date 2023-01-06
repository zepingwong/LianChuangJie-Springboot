package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.service.User.UserLogoutService;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserLogoutServiceImpl implements UserLogoutService {
    @Resource
    RedisUtil redisUtil;
    @Override
    public Boolean logoutService(HttpServletRequest request) {
        UserEntity user = ContextUtil.getUser();
        // 删除redis中的用户信息
        redisUtil.deleteObject("User:" + user.getUserSign());
        ContextUtil.removeSession(request);
        return true;
    }
}
