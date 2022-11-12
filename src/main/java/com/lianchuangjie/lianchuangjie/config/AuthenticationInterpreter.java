package com.lianchuangjie.lianchuangjie.config;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.utils.AuthUtil;
import com.lianchuangjie.lianchuangjie.utils.JWTUtil;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

public class AuthenticationInterpreter implements HandlerInterceptor {
    @Resource
    RedisUtil redisUtil;
    /**
     * 请求头 TOKEN 名称
     */
    private static final String HEADER_AUTH = "token";
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
        // 从http请求头获取token
        String token = request.getHeader(HEADER_AUTH);
        // 如果验证成功则放行请求
        // 解析 token 参数
        Map<String, Claim> claimMap = JWTUtil.verifyToken(token);
        if (!claimMap.get("UserSign").asString().equals("")) {
            // 请求开始将Redis存储的用户信息放入上下文对象
            UserEntity user = JSONObject.parseObject(redisUtil.getString(token), UserEntity.class);
            ContextUtil.setUser(user);
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
        return false;
    }

}