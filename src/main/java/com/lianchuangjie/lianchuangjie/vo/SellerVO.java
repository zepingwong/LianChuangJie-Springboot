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
public class SellerVO {
    /**
     * @description 销售员编号 SlpCode
     */
    @JsonProperty("SlpCode")
    private Long slpCode;
    /**
     * @description 销售员姓名 SlpName
     */
    @JsonProperty("SlpName")
    private String slpName;
    /**
     * @description
     */
    @JsonProperty("DeptCode")
    private String deptCode;
}
