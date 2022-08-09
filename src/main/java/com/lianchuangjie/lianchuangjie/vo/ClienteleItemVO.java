package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 业务合作伙伴代码、编号
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClienteleItemVO {
    // 业务合作伙伴代码-主键 CardCode
    @JsonProperty("CardCode")
    private String CardCode;
    // 业务合作伙伴名称 CardName
    @JsonProperty("CardName")
    private String CardName;
}
