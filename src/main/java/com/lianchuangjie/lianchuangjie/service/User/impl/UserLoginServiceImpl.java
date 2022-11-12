package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.Login.LoginError;
import com.lianchuangjie.lianchuangjie.mapper.User.UserMapper;
import com.lianchuangjie.lianchuangjie.service.User.UserLoginService;
import com.lianchuangjie.lianchuangjie.utils.JWTUtil;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import com.lianchuangjie.lianchuangjie.utils.SecurityUtil;
import com.lianchuangjie.lianchuangjie.vo.LoginResVO;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    UserMapper userMapper;
    @Resource
    RedisUtil redisUtil;
    @Override
    public LoginResVO employeeLoginService(EmployeeLoginDTO employee) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserCode", employee.getUserCode());
        // 根据 UserCode 查询用户
        UserEntity user = userMapper.selectOne(queryWrapper);
        // 断言用户不为空
        LoginError.ISNULL.assertNotNull(user, "员工账号不存在");
        // 密码错误
        String password = employee.getPassword();
        Boolean match = SecurityUtil.matchesPassword(password, user.getUPasswordWeb());
        LoginError.PASSWORD_ERROR.assertIsFalse(match, "登录失败，密码错误");
        if (password.equals("123456")) {
            user.setIsOldPassword("Y"); // 未修改密码
        }
        Map<String,String> payload = new HashMap<>();
        payload.put("id", String.valueOf(user.getUserSign()));
        payload.put("UserSign", String.valueOf(user.getUserSign()));
        // 生成token
        String tokenStr = JWTUtil.generateToken(payload);
        // 用户信息存入Redis, 使用token做redis的key 用户信息做value
        UserInfoVO userInfo = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfo);
        redisUtil.setString(tokenStr, JSONObject.toJSONString(userInfo));
        // 登录成功返回信息
        return new LoginResVO(userInfo, tokenStr);
    }
}
