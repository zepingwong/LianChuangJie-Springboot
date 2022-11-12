package com.lianchuangjie.lianchuangjie.service.User;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;

public interface UserInfoService extends IService<UserEntity> {
    /**
     * @param id id
     * @return UserEntity
     * @description 通过 Id 查询用户
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    UserEntity getOne(String id);

    /**
     * @param userSign userSign
     * @return UserEntity
     * @description 通过用户编号查询用户
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    UserEntity getOne(Long userSign);
}
