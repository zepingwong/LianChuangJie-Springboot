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
public class CompanyLetterheadVO {
    // 公司编号
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 公司代码
    @JsonProperty("ComCode")
    private String ComCode;
    // 公司名称
    @JsonProperty("Company")
    private String Company;
}
