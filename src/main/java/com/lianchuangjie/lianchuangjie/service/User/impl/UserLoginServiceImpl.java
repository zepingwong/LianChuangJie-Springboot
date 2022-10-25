package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.Login.LoginError;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.User.UserLoginService;
import com.lianchuangjie.lianchuangjie.utils.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    UserMapper userMapper;
    @Override
    public UserEntity employeeLoginService(EmployeeLoginDTO employee) {
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
        return user;
    }
}
