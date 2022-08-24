package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 销售报价页面-客户需求一行信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabEnquiryNeedsVO {
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
     * @description 询价客户名称 CardName
     * @resource T_ICIN.CardName
     */
    @JsonProperty("CardName")
    private String cardName;
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
    // 税率文本描述 U_VatName
    @JsonProperty("U_VatName")
    private String uVatName;
    /**
     * @description 销售报价单价 PriceAfVAT
     */
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    /**
     * @description 报价交期 Delivery
     */
    @JsonProperty("Delivery")
    private String delivery;
    /**
     * @description 销售备注 LineRemark
     */
    @JsonProperty("LineRemark")
    private String lineRemark;
    // 价格类型 U_ICIN1.Status
    @JsonProperty("Status")
    private String status;
}
