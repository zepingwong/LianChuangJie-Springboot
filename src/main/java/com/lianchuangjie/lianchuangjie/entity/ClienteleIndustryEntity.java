package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务合作伙伴行业领域表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OFIE")
public class ClienteleIndustryEntity {
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
