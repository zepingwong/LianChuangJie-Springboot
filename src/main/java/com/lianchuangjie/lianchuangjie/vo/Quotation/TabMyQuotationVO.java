package com.lianchuangjie.lianchuangjie.vo.Quotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabMyQuotationVO {
    /**
     * @description 报价单信息
     */
    // 采购报价时间 U_QuoDate
    @JsonProperty("U_QuoDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uQuoDate;
    // 询价单编号 U_BaseEntry
    @JsonProperty("U_BaseEntry")
    private Long uBaseEntry;
    // 状态 U_Status
    @JsonProperty("U_Status")
    private String uStatus;
    /**
     * @description 采购信息
     */
    // 负责采购员编号 T_ICIN1.U_Buyer
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 负责采购员姓名 T_OUSI.UserName
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    // 采购部门代码 T_OUSI.DftDept
    @JsonProperty("DftDept")
    private String dftDept;
    // 采购部门名称 T_OCDP.Name
    @JsonProperty("DftDeptName")
    private String dftDeptName;
    /**
     * @description 供应商信息
     */
    // 供应商代码 U_CardCode
    @JsonProperty("U_CardCode")
    private String uCardCode;
    // 供应商名称 U_CardName
    @JsonProperty("U_CardName")
    private String uCardName;
    // 采购报价供应商等级名称 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 采购报价供应商性质 T_ICIN1.U_QuoGroupCode
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 报价信息
     */
    // 采购报价型号 T_ICIN1.U_QuoModle
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
    // 供方报价 T_ICIN1.U_QuoPrice
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 供方交期 U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 供方备注 U_QuoRemark
    @JsonProperty("U_QuoRemark")
    private String uQuoRemark;
    /**
     * @description 税率+货币
     */
    // 采购报价货币 T_ICIN1.U_QuoCurr
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    // VatCur USD+J0+0
    @JsonProperty("CurVat")
    private String curVat;
    @JsonProperty("CurVatLabel")
    private String curVatLabel;
    // 税率代码
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // 税率税点
    @JsonProperty("U_VatRate")
    private BigDecimal uVatRate;
}
