package com.lianchuangjie.lianchuangjie.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLogSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
}
