package com.lianchuangjie.lianchuangjie.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.utils.AuthUtil;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterpreter implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull Object handler
    ) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ObjectMapper objectMapper = new ObjectMapper();
        Object object = SessionUtil.getSession(request,"User");
        ResponseEnum.SESSION_EXPIRED.assertNotNull(object,"Session已过期，请重新登录");
        UserEntity user = objectMapper.convertValue(object, UserEntity.class);
        // 请求开始将解析的用户信息放入上下文对象
        SessionUtil.setUserSign(user.getUserSign());
        // 如果不设置 @Authentication 注解，则对所有用户放行
        Authentication authentication = method.getAnnotation(Authentication.class);

        if (authentication == null) {
            return true;
        }else {
            // @Authentication 需要设置哪个角色具有访问权限，否则仅管理员具有访问权限
            AuthUtil authUtil = new AuthUtil(authentication);
            ResponseEnum.HAS_NO_AUTHENTICATION.assertIsFalse(authUtil.checkAuth(user), "无权访问 "+ request.getRequestURI() + " 接口");
        }
        return true;
    }

}