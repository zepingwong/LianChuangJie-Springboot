package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuotationSaveDTO {
    /**
     * @description 状态 U_Status
     */
    @JsonProperty("U_Status")
    private String uStatus;
    /**
     * @description 询价单编号-主键 DocEntry
     * @target U_ICIN1.DocEntry
     */
    @NotNull(message = "询价单编号不能为空")
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 行号-主键 LineNum
     * @target U_ICIN1.LineNum
     */
    @NotNull(message = "询价单行号不能为空")
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 无法报价
     * @target T_ICIN1.UnableQuote
     */
    @JsonProperty("UnableQuote")
    private String unableQuote;
    /**
     * @description U_KeyRemark 重点询价说明
     * @resource T_ICIN1.U_KeyRemark
     */
    @JsonProperty("U_KeyRemark")
    private String uKeyRemark;
    /**
     * @description 供应商代码 U_CardCode
     * @target T_ICIN1.U_CardCode
     */
    @NotBlank(message = "供应商代码不能为空")
    @JsonProperty("U_CardCode")
    private String uCardCode;
    /**
     * @description 供应商名称 U_CardName
     * @target T_ICIN1.U_CardName
     */
    @NotBlank(message = "供应商名称不能为空")
    @JsonProperty("U_CardName")
    private String uCardName;
    // U_QuoGroupCode 采购报价供应商性质
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 报价型号 U_QuoModle
     * @target T_ICIN1.U_QuoModle
     */
    @NotBlank(message = "报价型号不能为空")
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    /**
     * @description 采购报价数量 U_QuoQty
     * @target T_ICIN1.U_QuoQty
     */
    @NotNull(message = "报价数量不能为空")
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    /**
     * @description 单价 U_QuoPrice
     * @target T_ICIN1.U_QuoPrice
     */
    @NotNull(message = "供方报价不能为空")
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    /**
     * @description 采购报价货币 U_QuoCurr
     * @target T_ICIN1.U_QuoCurr
     */
    @NotNull(message = "报价货币不能为空")
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;

    public String getUQuoCurr() {
        String[] strList = uQuoCurr.split("\\+");
        return strList[0];
    }

    /**
     * @description 采购报价批次 U_QuoYear
     */
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    /**
     * @description 供方交期 U_QuoDelivery
     * @target T_ICIN1.U_QuoDelivery
     */
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    /**
     * @description 供方备注 U_QuoRemark
     * @target T_ICIN1.U_QuoRemark
     */
    @JsonProperty("U_QuoRemark")
    private String uQuoRemark;
    /**
     * @description 采购备注 U_Remark1
     * @target T_ICIN1.U_Remark1
     */
    @JsonProperty("U_Remark1")
    private String uRemark1;
    /**
     * @description 起订量
     * @target T_ICIN1.MinQty
     */
    @JsonProperty("MinQty")
    private Integer minQty;
    /**
     * @description 联系人
     * @target T_ICIN1.ContPerson
     */
    @JsonProperty("ContPerson")
    private String contPerson;
    /**
     * @description 电话
     * @target T_ICIN1.ContPhone
     */
    @JsonProperty("ContPhone")
    private String contPhone;
    /**
     * @description 地址
     * @target T_ICIN1.ContAddress
     */
    @JsonProperty("ContAddress")
    private String contAddress;
    /**
     * @description 邮箱
     * @resource T_ICIN1.ContEmail
     */
    @JsonProperty("ContEmail")
    private String contEmail;
    // 标准包装 T_ICIN1.StanPackage
    @JsonProperty("StanPackage")
    private String stanPackage;
    // 采购报价供应商等级名称 U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;

    // 采购报价税率代码 U_QuoVatGroup
    private String uQuoVatGroup;

    public String getUQuoVatGroup() {
        String[] strList = uQuoCurr.split("\\+");
        return strList[1];
    }

    // 采购报价品牌 U_QuoBrand
    @JsonProperty(value = "U_QuoBrand")
    private String uQuoBrand;
    /**
     * 客户信息
     */
    // 客户行业领域 U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 客户等级
    @JsonProperty("U_U_Level")
    private String uULevel;
    // 需求销项税代码
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // 客户性质名称
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
    /**
     * @description 客户需求
     */
    // 需求交期 U_Delivery
    @JsonProperty("U_Delivery")
    private String uDelivery;
    // 需求型号
    @JsonProperty("Modle")
    private String modle;
    // 需求品牌
    @JsonProperty("Brand")
    private String brand;
    // 需求批次 Year
    @JsonProperty("Year")
    private String year;
    // 需求数量 DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 预估价格/参考价格 U_PrePrice
    @JsonProperty("U_PrePrice")
    private BigDecimal uPrePrice;
    private BigDecimal uPreTotal;
    public BigDecimal getUPreTotal() {
        return uPrePrice.multiply(demandQty);
    }
    // 发送时间/录入时间 InquiryDate
    @JsonProperty("DemandDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接参数
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date demandDate;
    // 保密
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    // 接受价格 ExpectedPrice U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    // 重要程度 U_KeyPoint
    @JsonProperty("U_KeyPoint")
    private String uKeyPoint;
    // 客户简称代码
    @JsonProperty("U_ShortCode")
    private String uShortCode;
    // 关联询价单编号
    private Long uBaseEntry;

    public Long getUBaseEntry() {
        return docEntry;
    }

    // 关联询价单行号
    private Long uBaseLine;

    public Long getUBaseLine() {
        return lineNum;
    }
}
