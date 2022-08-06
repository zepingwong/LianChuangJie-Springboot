package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("T_OUSI")
public class UserEntity {
    // 用户编号
    private Long UserSign;
    // 用户姓名
    private String UserName;
    // 用户Id
    private String UserCode;
    // 用户密码
    private String Password;
}
