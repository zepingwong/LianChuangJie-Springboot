package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.UserLoginService;
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
        UserEntity user = userMapper.getOne(queryWrapper);
        // 断言用户不为空
        ResponseEnum.ISNULL.assertNotNull(user, "员工账号不存在");
        // 密码错误
        String password = employee.getPassword();
        ResponseEnum.PASSWORD_ERROR.assertNotEqual(password, "123", "登录失败，密码错误");
        return user;
    }
}