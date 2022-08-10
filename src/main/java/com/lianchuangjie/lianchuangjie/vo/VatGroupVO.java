package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VatGroupVO {
    // 税率代码
    @JsonProperty("Code")
    private String Code;
    // 名称
    @JsonProperty("Name")
    private String Name;
    // 类型
    @JsonProperty("Type")
    private String Type;
    // 税率
    @JsonProperty("Rate")
    private BigDecimal Rate;
}
