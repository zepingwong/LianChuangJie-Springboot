package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;

public interface UserInfoService extends IService<UserEntity> {
    UserInfoVO getOne(QueryWrapper<UserInfoVO> queryWrapper);
}
