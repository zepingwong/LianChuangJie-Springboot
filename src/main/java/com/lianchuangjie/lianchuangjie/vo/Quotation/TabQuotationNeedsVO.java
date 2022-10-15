package com.lianchuangjie.lianchuangjie.vo.Quotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 采购报价页面-客户需求TAB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabQuotationNeedsVO {
    /**
     * @description 询价单编号-主键 DocEntry
     * @resource U_ICIN1.DocEntry
     */
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 行号-主键 LineNum
     * @resource U_ICIN1.LineNum
     */
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 询价日期 InquiryDate
     * @resource T_ICIN.InquiryDate
     */
    @JsonProperty("InquiryDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inquiryDate;
    /**
     * @description 销售员姓名 UserName
     * @resource T_ICIN.U_UserName
     */
    @JsonProperty("U_UserName")
    private String uUserName;
    /**
     * @description 销售部门名称
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
     * @description 保密 Secrecy
     * @resource U_ICIN1.Secrecy
     */
    @JsonProperty("Secrecy")
    private String secrecy;
    /**
     * @description 需求型号 Modle
     * @resource U_ICIN1.Modle
     */
    @JsonProperty("Modle")
    private String modle;
    /**
     * @description 需求品牌 Brand
     * @resource U_ICIN1.Brand
     */
    @JsonProperty("Brand")
    private String brand;
    /**
     * @description 需求数量 DemandQty
     * @resource U_ICIN1.DemandQty
     */
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    /**
     * @description ECCN ECCN
     * @resource U_ICIN1.ECCN
     */
    @JsonProperty("ECCN")
    private String eccn;
    // 报价货币 U_ICIN1.U_DocCur
    @JsonProperty("U_DocCur")
    private String uDocCur;
    // 引用采购报价税率 U_ICIN1.U_VatGroup
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // 税率文本描述 U_VatName
    @JsonProperty("U_VatName")
    private String uVatName;
    // 税点 U_VatRate
    @JsonProperty("U_VatRate")
    private BigDecimal uVatRate;
    /**
     * @description 报价交期 SuoDelivery
     */
    @JsonProperty("SuoDelivery")
    private String suoDelivery;
    /**
     * @description 销售备注 LineRemark
     */
    @JsonProperty("LineRemark")
    private String lineRemark;
}
