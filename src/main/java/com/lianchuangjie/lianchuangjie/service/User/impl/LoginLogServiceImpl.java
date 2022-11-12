package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.User.LoginLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.User.LoginLogMapper;
import com.lianchuangjie.lianchuangjie.service.User.LoginLogService;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogEntity> implements LoginLogService {
}
