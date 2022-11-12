package com.lianchuangjie.lianchuangjie.service.User.impl;

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
        ContextUtil.removeSession(request);
        // 删除redis中的用户信息
        redisUtil.removeString(request.getHeader("token"));
        return true;
    }
}
