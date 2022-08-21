package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleQueryDTO {
    // 型号
    @JsonProperty("Modle")
    private String modle;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 需求数量 DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal DemandQty;
    // 销售员
    @JsonProperty("SlpCode")
    private Long slpCode;
    // 销售部门
    @JsonProperty("DeptCode")
    private String deptCode;
}
