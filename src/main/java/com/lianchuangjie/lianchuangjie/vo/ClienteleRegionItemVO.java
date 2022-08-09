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
public class ClienteleRegionItemVO {
    // 地区代码
    @JsonProperty("KeyCode")
    private Integer KeyCode;
    // 地区名称
    @JsonProperty("DoMain")
    private String DoMain;
    // 一级地区代码
    @JsonProperty("ParentCode")
    private Integer ParentCode;
    // 简称-只有一级地区有简称
    @JsonProperty("ShortName")
    private String ShortName;
}
