package com.lianchuangjie.lianchuangjie.searchDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 * 采购询价转发规则
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryBuyerSearchDTO {
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 销售员代码
    @JsonProperty("SlpCode")
    private Long slpCode;
    // 部门代码
    @JsonProperty("DeptCode")
    private String deptCode;
    // ECCN码
    @JsonProperty("ECCN")
    private String eccn;
    // 询价起点
    @JsonProperty("StartTotal")
    private BigDecimal startTotal;
}
