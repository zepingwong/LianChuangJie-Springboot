package com.lianchuangjie.lianchuangjie.vo;

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
     * @description 采购报价时间 U_QuoDate
     * @resource T_ICIN1.U_QuoDate
     */
    @JsonProperty("U_QuoDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uQuoDate;
    /**
     * @description 询价单编号 DocEntry
     * @resource T_ICIN1.DocEntry
     */
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 供应商代码 U_CardCode
     * @resource T_ICIN1.U_CardCode
     */
    @JsonProperty("U_CardCode")
    private String uCardCode;
    /**
     * @description 供应商名称 U_CardName
     * @resource T_ICIN1.U_CardName
     */
    @JsonProperty("U_CardName")
    private String uCardName;
    /**
     * @description 采购报价供应商等级名称 U_QuoLevel
     * @resource T_ICIN1.U_QuoLevel
     */
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    /**
     * @description 采购报价供应商性质 U_QuoGroupCode
     * @resource T_ICIN1.U_QuoGroupCode
     */
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 负责采购员编号 U_Buyer
     * @resource T_ICIN1.U_Buyer
     */
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    /**
     * @description 负责采购员姓名 U_BuyerName
     * @resource T_OUSI.UserName
     */
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    /**
     * @description 采购部门代码
     * @resource T_OUSI.DftDept
     */
    @JsonProperty("DftDept")
    private String dftDept;
    /**
     * @description 采购部门名称 DftDeptName
     * @resource T_OCDP.Name
     */
    @JsonProperty("DftDeptName")
    private String dftDeptName;
    /**
     * @description 采购报价型号 U_QuoModle
     * @resource T_ICIN1.U_QuoModle
     */
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    /**
     * @description 采购报价数量 U_QuoQty
     * @resource T_ICIN1.U_QuoQty
     */
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    /**
     * @description 采购报价批次 U_QuoYear
     * @resource T_ICIN1.U_QuoYear
     */
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    /**
     * @description 供方报价 U_QuoPrice
     * @resource T_ICIN1.U_QuoPrice
     */
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    /**
     * @description 采购报价货币 U_QuoCurr
     * @resource T_ICIN1.U_QuoCurr
     */
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    /**
     * @description 供方交期 U_QuoDelivery
     * @resource T_ICIN1.U_QuoDelivery
     */
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    /**
     * @description 采购备注 U_Remark1
     * @resource T_ICIN1.U_Remark1
     */
    @JsonProperty("U_Remark1")
    private String uRemark1;
    /**
     * @description 状态 U_Status
     */
    @JsonProperty("U_Status")
    private String uStatus;
}
