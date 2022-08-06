package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description 登录接口返回数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginResVO {
    // 用户编号
    @JsonProperty("UserSign")
    private Long UserSign;
    // 用户姓名
    @JsonProperty("UserName")
    private String UserName;
    // 用户Id
    @JsonProperty("UserCode")
    private String UserCode;
}
