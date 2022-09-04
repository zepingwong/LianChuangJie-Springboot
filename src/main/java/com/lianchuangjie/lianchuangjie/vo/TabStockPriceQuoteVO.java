package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 库存定价-采购报价
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabStockPriceQuoteVO {
    // 报价日期
    @JsonProperty("QuoDate")
    private Date quoDate;
    // 供应商类型 T_ICIN1.U_QuoGroupCode
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    // 供应商等级
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 负责采购员编号 T_ICIN1.U_Buyer
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 负责采购员姓名 T_OUSI.UserName
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    // 采购部门
    @JsonProperty("DftDeptName")
    private String dftDeptName;
    // 型号 T_ICIN1.U_QuoModle
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    // 采购报价品牌 T_ICIN1.U_QuoBrand
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    // 采购报价数量 T_ICIN1.U_QuoQty
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    // 采购报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 采购报价货币 T_ICIN1.U_QuoCurr
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    // 供方报价 T_ICIN1.U_QuoPrice
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 税率税点 T_OVTG.Rate
    @JsonProperty("U_QuoVatRate")
    private BigDecimal uQuoVatRate;
    // 供方交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 采购备注 T_ICIN1.U_QuoExplain
    @JsonProperty("U_QuoExplain")
    private String uQuoExplain;
}
