package com.lianchuangjie.lianchuangjie.service.User;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;

public interface UserAvatarService extends IService<UserEntity> {
    Boolean upload(String avatar);
}
