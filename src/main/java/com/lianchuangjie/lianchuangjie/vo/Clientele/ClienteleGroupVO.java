package com.lianchuangjie.lianchuangjie.vo.Clientele;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 业务合作伙伴性质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClienteleGroupVO {
    // 业务合作伙伴性质代码
    @JsonProperty("Code")
    private Integer Code;
    // 业务合作伙伴性质名称
    @JsonProperty("Name")
    private String Name;
    // 业务合作伙伴性质：供应商/客户
    @JsonProperty("Type")
    private String Type;
    // 业务合作伙伴性质简称
    @JsonProperty("U_ShortName")
    private String uShortName;
}
