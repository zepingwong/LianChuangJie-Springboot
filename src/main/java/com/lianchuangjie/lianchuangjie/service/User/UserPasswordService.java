package com.lianchuangjie.lianchuangjie.service.User;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.UserPasswordDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;

public interface UserPasswordService extends IService<UserEntity> {
    Boolean setUserPassword(UserPasswordDTO userPasswordDTO);
}
