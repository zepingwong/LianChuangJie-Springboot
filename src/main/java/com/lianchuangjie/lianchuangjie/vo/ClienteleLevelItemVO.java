package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClienteleLevelItemVO {
    // 等级代码
    @JsonProperty("Code")
    private Integer code;
    // 等级
    @JsonProperty("Level")
    private String level;
}
