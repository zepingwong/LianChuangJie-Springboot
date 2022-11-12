package com.lianchuangjie.lianchuangjie.entity.User;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description 用户登录日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_WebLogin")
public class LoginLogEntity {
    @TableId(value = "DocEntry")
    private Long docEntry;
    // 用户编号
    @TableField(value = "UserSign")
    private Long userSign;
    // 登录IP
    @TableField(value = "LoginIP")
    private String loginIP;
    // 登录时间
    @TableField(value = "LoginTime")
    private Date loginTime;
}
