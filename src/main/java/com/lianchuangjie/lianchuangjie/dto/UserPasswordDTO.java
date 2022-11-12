package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @description 修改密码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordDTO {
    // 新密码
    @NotBlank(message = "新密码不能为空")
    @JsonProperty("NewPassword")
    private String newPassword;
    // 原密码
    @NotBlank(message = "旧密码不能为空")
    @JsonProperty("OldPassword")
    private String oldPassword;
    // 确认密码
    @NotBlank(message = "确认密码不能为空")
    @JsonProperty("ConfirmPassword")
    private String confirmPassword;
    // UserSign 用户编号
    private Long userSign = ContextUtil.getUser().getUserSign();
}
