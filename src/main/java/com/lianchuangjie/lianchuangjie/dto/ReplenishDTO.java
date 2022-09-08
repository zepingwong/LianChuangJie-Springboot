package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 1. 补价 库存定价插入到采购报价
 * 2. 不关联任何询价单 U_BaseEntry、U_BaseLine 为 null
 * 3. DocEntry、LineNum 如何编号 : DocEntry 可以用 0，LineNum 自增长
 * 4. 按找常规需求处理，一个月内的存在 T_ICIN1、超过一个月存在 U_ICIN11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplenishDTO {
    /**
     * @description 报价信息
     */
    // 报价品牌
    @NotBlank(message = "品牌不能为空")
    @JsonProperty("Brand")
    private String uQuoBrand;
    // 报价型号
    @NotBlank(message = "型号不能为空")
    @JsonProperty("ItemName")
    private String uQuoModle;
    // 采购报价数量 T_ICIN1.U_QuoQty
    @NotNull(message = "报价数量不能为空")
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    // 供方报价 T_ICIN1.U_QuoPrice
    @NotNull(message = "供方报价不能为空")
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 采购报价货币 T_ICIN1.U_QuoCurr
    @NotNull(message = "报价货币不能为空")
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    public String getUQuoCurr() {
        String[] strList = uQuoCurr.split("\\+");
        return strList[0];
    }
    // 采购报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 供方交期 T_ICIN1.U_QuoDelivery
    @NotBlank(message = "供方交期不能为空")
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 采购报价税率代码 U_QuoVatGroup
    private String uQuoVatGroup;
    public String getUQuoVatGroup() {
        String[] strList = uQuoCurr.split("\\+");
        return strList[1];
    }
    // Buyer 采购员
    private Integer uBuyer;
    // 报价状态
    private String lineInquiryStatus = String.valueOf('Y');
    /**
     * @description 供应商
     */
    // 供应商代码 U_CardCode
    @NotBlank(message = "供应商代码不能为空")
    @JsonProperty("U_CardCode")
    private String uCardCode;
    // 供应商名称 T_ICIN1.U_CardName
    @NotBlank(message = "供应商名称不能为空")
    @JsonProperty("U_CardName")
    private String uCardName;
    // U_QuoGroupCode 采购报价供应商性质
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    // 采购报价供应商等级名称 U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
}
