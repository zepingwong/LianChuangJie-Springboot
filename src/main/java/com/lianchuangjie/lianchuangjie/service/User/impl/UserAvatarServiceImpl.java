package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.User.UserMapper;
import com.lianchuangjie.lianchuangjie.service.User.UserAvatarService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.lianchuangjie.lianchuangjie.utils.Base64Util;

import javax.annotation.Resource;


@Service
public class UserAvatarServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserAvatarService {
    @Value("${localImgPath}")
    String localImgPath;
    @Value("${networkImgPath}")
    String networkImgPath;
    @Resource
    UserMapper userMapper;
    @Override
    public Boolean upload(String avatar) {
        try {
            // 存图片
            if (avatar != null && !avatar.equals("")) {
                avatar = networkImgPath + "avatar/" + Base64Util.generateImage(avatar, localImgPath + "avatar");
                UserEntity user = SessionUtil.getUser();
                user.setUAvatar(avatar);
                userMapper.updateById(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
