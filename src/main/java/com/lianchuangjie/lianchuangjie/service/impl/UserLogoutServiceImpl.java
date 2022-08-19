package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.service.UserLogoutService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserLogoutServiceImpl implements UserLogoutService {
    @Override
    public Boolean logoutService(HttpServletRequest request) {
        SessionUtil.removeSession(request);
        return true;
    }
}
