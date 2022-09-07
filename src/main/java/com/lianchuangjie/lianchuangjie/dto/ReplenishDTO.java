package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 1. 补价 库存定价插入到采购报价
 * 2. 不关联任何询价单 U_BaseEntry、U_BaseLine 为 null
 * 3. DocEntry、LineNum 如何编号 : DocEntry 可以用 0，LineNum 自增长
 * 4. 按找常规需求处理，一个月内的存在 T_ICIN1、超过一个月存在 U_ICIN11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplenishDTO {
    // 品牌
    @NotBlank(message = "品牌不能为空")
    @JsonProperty("Brand")
    private String uQuoBrand;
    // 型号
    @NotBlank(message = "型号不能为空")
    @JsonProperty("ItemName")
    private String uQuoModle;
    // Buyer 采购员
    private Integer uBuyer;
    // 报价数量 U_QuoQty
    private BigDecimal uQuoQty;
    // 报价价格

    // 报价状态
    private String lineInquiryStatus;
}
