package com.lianchuangjie.lianchuangjie.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public <T> void setSession(HttpServletRequest request, String SessionName, T SessionValue) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionName,SessionValue);
        // 设置 Session 7天过期
        session.setMaxInactiveInterval(60*60*24*7);
    }

    public Object getSession(HttpServletRequest request, String sessionName) {
        HttpSession session = request.getSession();
        return session.getAttribute(sessionName);
    }
    public static Boolean removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }
}
