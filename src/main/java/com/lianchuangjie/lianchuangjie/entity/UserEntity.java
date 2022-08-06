package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private Long UserSign;
    // 用户姓名
    private String UserName;
    // 用户Id
    private String UserCode;
    // 用户密码
    private String Password;
    // 所属部门代码
    private String DftDept;
    // 所属部门名称 T_OCDP.Name
    @TableField(exist = false)
    private String DftDeptName;
    // 头像URL
    private String Avatar;
    // 是否为采购员
    private String uIsBuyer;
    // 是否为销售员
    private String uIsSale;
    // 是否为虚拟用户
    private String uIsVir;
    // 是否为管理员
    private String SuperUser;
    // 修改密码日期
    private Date ModifyPwdDate;
}
