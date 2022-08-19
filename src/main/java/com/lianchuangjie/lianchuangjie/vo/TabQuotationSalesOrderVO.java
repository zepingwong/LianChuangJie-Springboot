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
public class TabQuotationSalesOrderVO {
    /**
     * @description 订单日期 DocDate
     * @resource T_ORDR.DocDate
     */
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    /**
     * @description 销售员编号
     * @resource T_ICIN.OwnerCode
     */
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    /**
     * @description 销售员姓名 U_UserName
     * @resource T_ICIN.U_UserName
     */
    @JsonProperty("U_UserName")
    private String uUserName;
    /**
     * @description 销售部门名称 U_DeptName
     * @resource T_ICIN.U_DeptName
     */
    @JsonProperty("U_DeptName")
    private String uDeptName;
    /**
     * @description 需求客户性质名称 U_CusGroupCode
     * @resource T_ICIN.U_CusGroupCode
     */
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
    /**
     * @description 需求客户等级名称 U_CusLevel
     * @resource T_ICIN.U_CusLevel
     */
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    /**
     * @description 需求客户行业领域名称 U_DomainName
     * @resource T_ICIN.U_DomainName
     */
    @JsonProperty("U_DomainName")
    private String uDomainName;
    /**
     * @description 是否保密标记 Secrecy
     * @resource U_ICIN1.Secrecy
     */
    @JsonProperty("Secrecy")
    private String secrecy;
    /**
     * @description 报价型号 QuoModle
     * @resource U_ICIN1.QuoModle
     */
    @JsonProperty("QuoModle")
    private String quoModle;
    /**
     * @description 报价品牌 QuoBrand
     * @resource U_ICIN1.QuoBrand
     */
    @JsonProperty("QuoBrand")
    private String quoBrand;
    /**
     * @description 报价批次 SuoYear
     * @resource U_ICIN1.SuoYear
     */
    @JsonProperty("SuoYear")
    private String suoYear;
    /**
     * @description 订单数量 Quantity
     * @resource T_ORDR1.Quantity
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    /**
     * @description 未交数量 OpenQty
     * @resource T_ORDR1.OpenQty
     */
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    /**
     * @description U_ECCN
     * @resource T_ORDR1.U_ECCN
     */
    @JsonProperty("U_ECCN")
    private String uEccn;
    /**
     * @description 币种 DocCur
     * @resource T_ORDR.DocCur
     */
    @JsonProperty("DocCur")
    private String docCur;
    /**
     * @description 税率代码 U_VatGroup
     * @resource T_ORDR1.U_VatGroup
     */
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    /**
     * @description 税率文本 U_VatName
     * @description T_OVTG.Name
     */
    @JsonProperty("U_VatName")
    private String uVatName;
    /**
     * @description 税点 U_VatRate
     * @description T_OVTG.Rate
     */
    @JsonProperty("U_VatRate")
    private BigDecimal uVatRate;
    /**
     * @description 含税单价
     * @resource T_ORDR1.U_PriceAfVAT
     */
    @JsonProperty("U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;
    /**
     * @description 预计交期 ShipDate
     * @resource T_ORDR1.ShipDate
     */
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shipDate;
    /**
     * @description U_Remark 备注
     * @resource T_ORDR1.U_Remark
     */
    @JsonProperty("U_Remark")
    private String uRemark;
}
