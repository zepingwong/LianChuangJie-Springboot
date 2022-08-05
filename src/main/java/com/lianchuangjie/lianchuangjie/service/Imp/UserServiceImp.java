package com.lianchuangjie.lianchuangjie.service.Imp;

import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.po.User;
import com.lianchuangjie.lianchuangjie.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImp implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public Boolean login(User user) {

        User thisUser = userMapper.selectByUserCode(user.getUserCode());
        System.out.println(thisUser);
        if (thisUser == null) {
            return false;
        }
        return true;
    }
}
