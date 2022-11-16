package com.lianchuangjie.lianchuangjie.vo.User;

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
public class LoginLogVO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 用户编号
    @JsonProperty("UserSign")
    private Long userSign;
    // 登录IP
    @JsonProperty("LoginIP")
    private String loginIP;
    // 登录时间
    @JsonProperty("LoginTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;
    @JsonProperty("UserName")
    private String userName;
}
