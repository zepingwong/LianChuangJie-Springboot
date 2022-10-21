package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OUSI")
public class UserEntity {
    // 用户编号
    @TableId(value = "UserSign")
    private Long userSign;
    // 用户姓名
    @TableField(value = "UserName")
    private String userName;
    // 用户Id
    @TableField(value = "UserCode")
    private String userCode;
    // 用户密码
    @TableField(value = "Password")
    private String password;
    // 所属部门代码
    @TableField(value = "DftDept")
    private String dftDept;
    // 所属部门名称 T_OCDP.Name
    @TableField(exist = false)
    private String DftDeptName;
    // 头像URL
    @TableField(value = "U_Avatar")
    private String uAvatar;
    // 是否为采购员
    @TableField(value = "U_IsBuyer")
    private String uIsBuyer;
    // 是否为销售员
    @TableField(value = "U_IsSale")
    private String uIsSale;
    // 是否为虚拟用户
    @TableField(value = "U_IsVir")
    private String uIsVir;
    // 是否为管理员
    @TableField(value = "SuperUser")
    private String superUser;
    // 修改密码日期
    @TableField(value = "ModifyPwdDate")
    private Date modifyPwdDate;
    @TableField(value = "U_PasswordWeb")
    private String uPasswordWeb;
    // 初始密码未修改
    @TableField(exist = false)
    private String isOldPassword;
}
