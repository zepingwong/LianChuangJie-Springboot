package com.lianchuangjie.lianchuangjie.utils;


import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import org.assertj.core.api.Object2DArrayAssert;

import java.util.Objects;
/**
 * @description 权限验证工具
 * @date 2022-06-03
 */
public class AuthUtil {
    private final Boolean isBuyer;
    private final Boolean isSale;
    private final Boolean isSaleAssist;

    public AuthUtil(Authentication authentication) {
        this.isBuyer = authentication.buyer();
        this.isSale = authentication.sale();
        this.isSaleAssist = authentication.saleAssist();
    }
    public Boolean checkAuth(UserEntity user) {
        // 管理员可以访问所有接口
        // 其他角色需要鉴权
        return (Objects.equals(user.getSuperUser(), "Y") |
                (this.isBuyer & Objects.equals(user.getUIsBuyer(), "Y")) |
                (this.isSale & Objects.equals(user.getUIsSale(), "Y")) |
                (this.isSaleAssist & Objects.equals(user.getUIsSaleAssist(), "Y"))
        );
    }
}
