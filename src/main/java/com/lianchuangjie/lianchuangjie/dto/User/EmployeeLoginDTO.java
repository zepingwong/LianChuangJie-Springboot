package com.lianchuangjie.lianchuangjie.dto.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLoginDTO {
    // 用户Id
    @NotBlank(message = "员工ID不能为空")
    @JsonProperty("UserCode")
    private String UserCode;
    // 用户密码
    @JsonProperty("Password")
    @NotBlank(message = "员工密码不能为空")
    private String Password;
}
