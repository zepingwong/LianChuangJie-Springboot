package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoVO {
    // 用户编号 T_OUSI.UserSign
    @JsonProperty("UserSign")
    private Long userSign;
    // 用户姓名 T_OUSI.UserName
    @JsonProperty("UserName")
    private String userName;
    // 用户Id T_OUSI.UserCode
    @JsonProperty("UserCode")
    private String userCode;
    // 所属部门代码 T_OUSI.DftDept
    @JsonProperty("DftDept")
    private String dftDept;
    // 所属部门名称 T_OCDP.Name
    @JsonProperty("DftDeptName")
    private String dftDeptName;
    // 头像URL T_OUSI.Avatar
    @JsonProperty("U_Avatar")
    private String uAvatar;
    // 是否为采购员 T_OUSI.U_IsBuyer
    @JsonProperty("U_IsBuyer")
    private String uIsBuyer;
    // 是否为销售员 T_OUSI.U_IsSale
    @JsonProperty("U_IsSale")
    private String uIsSale;
    // 是否为虚拟用户 T_OUSI.U_IsVir
    @JsonProperty("U_IsVir")
    private String uIsVir;
    // 是否为管理员 T_OUSI.SuperUser
    @JsonProperty("SuperUser")
    private String superUser;
    // 修改密码日期 T_OUSI.ModifyPwdDate
    @JsonProperty("ModifyPwdDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyPwdDate;
}
