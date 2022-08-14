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
public class QuotationVO {
    /**
     * @description 状态 U_Status
     * @resource U_ICIN1.U_Status
     */
    @JsonProperty("U_Status")
    private String uStatus;
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
     * @description ItemId 关联型号 ItemId 相同
     */
    @JsonProperty("ItemId")
    private Long itemId;
    /**
     * @description 重要程度
     * @resource U_ICIN1.KeyPoint
     */
    @JsonProperty("KeyPoint")
    private String keyPoint;
    /**
     * @description 需求型号 Modle
     * @resource U_ICIN1.Modle
     */
    @JsonProperty("Modle")
    private String modle;
    /**
     * @description 采购报价型号 U_QuoModle
     */
    @JsonProperty("U_QuoModle")
    private String uQuoModle;

    public String getUQuoModle() {
        return uQuoModle == null ? modle : uQuoModle;
    }

    /**
     * @description 需求品牌 Brand
     * @resource U_ICIN1.Brand
     */
    @JsonProperty("Brand")
    private String brand;
    /**
     * @description 采购报价品牌 U_QuoBrand
     */
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;

    public String getUQuoBrand() {
        return uQuoBrand == null ? brand : uQuoBrand;
    }

    /**
     * @description 需求数量 DemandQty
     * @resource U_ICIN1.DemandQty
     */
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    /**
     * @description 接受价格 ExpectedPrice
     * @resource U_ICIN1.ExpectedPrice
     */
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    /**
     * @description U_KeyRemark 重点询价说明
     * @resource T_ICIN1.U_KeyRemark
     */
    @JsonProperty("U_KeyRemark")
    private String uKeyRemark;
    /**
     * @description 销售备注 LineRemark
     * @resource U_ICIN1.LineRemark
     */
    @JsonProperty("LineRemark")
    private String lineRemark;
    /**
     * @description 需求批次 Year
     * @resource U_ICIN1.Year
     */
    @JsonProperty("Year")
    private String year;
    /**
     * @description 需求交期 Delivery
     * @resource U_ICIN1.Delivery
     */
    @JsonProperty("Delivery")
    private String delivery;
    /**
     * @description 无法报价 UnableQuote
     */
    @JsonProperty("UnableQuote")
    private String unableQuote;
    /**
     * @description 销售员编号
     * @resource 根据 U_ICIN1.DocEntry 匹配 T_ICIN.DocEntry 获取 T_ICIN.OwnerCode
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
     * @description 销售部门名称
     * @resource T_ICIN.U_DeptName
     */
    @JsonProperty("U_DeptName")
    private String uDeptName;
    /**
     * @description 需求客户行业领域名称 U_DomainName
     * @resource T_ICIN.U_DomainName
     */
    @JsonProperty("U_DomainName")
    private String uDomainName;
    /**
     * @description 发送时间/录入时间 InquiryDate
     * @resource T_ICIN.InquiryDate
     */
    @JsonProperty("InquiryDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inquiryDate;
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
     * @description 采购报价数量 U_QuoQty
     * @resource T_ICIN1.U_QuoQty
     */
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;

    public BigDecimal getUQuoQty() {
        return uQuoQty == null ? demandQty : uQuoQty;
    }

    /**
     * @description 单价 U_QuoPrice
     * @resource T_ICIN1.U_QuoPrice
     */
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    /**
     * @description 采购报价批次 U_QuoYear
     */
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    /**
     * @description 采购报价货币 U_QuoCurr
     * @resource T_ICIN1.U_QuoCurr
     */
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    @JsonProperty("U_QuoVatGroup")
    private String uQuoVatGroup;
    @JsonProperty("U_QuoVatRate")
    private BigDecimal uQuoVatRate;
    public String getUQuoCurr() {
        return (uQuoCurr != null ? uQuoCurr : "") + (uQuoVatRate != null ? "（" + uQuoVatRate.stripTrailingZeros() + "%）" : "");
    }
    /**
     * @description 供方交期 U_QuoDelivery
     * @resource T_ICIN1.U_QuoDelivery
     */
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;

    public String getUQuoDelivery() {
        if (uQuoDelivery != null) {
            return uQuoDelivery;
        } else {
            if (delivery != null) {
                String[] strList = delivery.replace("周", "").split("-");
                return (Integer.parseInt(strList[0]) + 2) + "-" + (Integer.parseInt(strList[1]) + 2) + "周";
            } else {
                return null;
            }
        }
    }

    /**
     * @description 采购备注 U_Remark1
     * @resource T_ICIN1.U_Remark1
     */
    @JsonProperty("U_Remark1")
    private String uRemark1;
    /**
     * @description 供方备注 U_QuoRemark
     * @resource T_ICIN1.U_QuoRemark
     */
    @JsonProperty("U_QuoRemark")
    private String uQuoRemark;
    /**
     * @description 起订量
     * @resource T_ICIN1.MinQty
     */
    @JsonProperty("MinQty")
    private Integer minQty;
    /**
     * @description 联系人
     * @resource T_ICIN1.ContPerson
     */
    @JsonProperty("ContPerson")
    private String contPerson;
    /**
     * @description 电话
     * @resource T_ICIN1.ContPhone
     */
    @JsonProperty("ContPhone")
    private String contPhone;
    /**
     * @description 地址
     * @resource T_ICIN1.ContAddress
     */
    @JsonProperty("ContAddress")
    private String contAddress;
    /**
     * @description 邮箱
     * @resource T_ICIN1.ContEmail
     */
    @JsonProperty("ContEmail")
    private String contEmail;
    /**
     * @description 标准包装
     * @resource T_ICIN1.StanPackage
     */
    @JsonProperty("StanPackage")
    private String stanPackage;
    /**
     * @description 采购报价供应商等级名称 U_QuoLevel
     * @resource T_ICIN1.U_QuoLevel
     */
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    /**
     * @description 失效时间
     * @resource U_ICIN1.ExpDate
     */
    @JsonProperty("ExpDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expDate;

    /**
     * @description 到期时间 InvalidDate 当距离到期时间超过24h时，显示距离到期时间天数，否则显示距离到期时间小时数；当超过过期时间超过24h时，显示超过到期时间天数，否则显示超过到期时间小时数
     */
    @JsonProperty("InvalidDate")
    private String invalidDate;

    public String getInvalidDate() {
        // 是否有失效时间
        if (expDate != null) {
            Date date = new Date();
            long offset = date.getTime() - expDate.getTime() - 28800000L; // 要剪掉 8 小时时区差值
            if (offset < 0) {
                // 未到
                String str = offset < -86400000 ? Math.round(offset / 86400000.0) + "T" : Math.round(offset / 3600000.0) + "H";
                return str.replace("-", "");
            } else {
                // 已过期
                return offset > 86400000 ? "-" + Math.round(offset / 86400000.0) + "T" : "-" + Math.round(offset / 3600000.0) + "H";
            }
        } else {
            return null;
        }
    }

    /**
     * @description 对应采购报价表行号
     * @target T_ICIN1.LineNum
     */
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 预估价格
    @JsonProperty("U_PrePrice")
    private BigDecimal uPrePrice;
    // ECCN
    @JsonProperty("ECCN")
    private String ECCN;
    // 保密
    @JsonProperty("Secrecy")
    private String secrecy;
    // 客户行业领域 U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 需求销项税代码 U_VatGroup
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // 需求客户性质名称 U_CusGroupCode
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
     // 需求客户等级名称 U_CusLevel
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    @JsonProperty("U_ShortCode")
    private String uShortCode;

}
