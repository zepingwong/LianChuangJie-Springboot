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
public class ClienteleIndustryItemVO {
    // 业务合作伙伴行业领域代码
    @JsonProperty("KeyCode")
    private String KeyCode;
    // 业务合作伙伴行业领域名称
    @JsonProperty("DomainName")
    private String DomainName;
    // 父级代码
    @JsonProperty("ParentCode")
    private String ParentCode;
}
