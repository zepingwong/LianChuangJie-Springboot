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
public class QuotationVO {
    /**
     * @description 编号
     */
    // 询价单编号-主键 T_ICIN1.DocEntry
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 行号-主键 T_ICIN1.LineNum
    @JsonProperty("LineNum")
    private Long lineNum;
    // 关联报价单编号
    @JsonProperty("U_BaseEntry")
    private Long uBaseEntry;
    // 关联报价单行号
    @JsonProperty("U_BaseLine")
    private Long uBaseLine;
    // ItemId 关联型号 ItemId 相同
    @JsonProperty("ItemId")
    private Long itemId;
    /**
     * @description 客户需求
     */
    // 需求品牌 U_ICIN1.Brand
    @JsonProperty("Brand")
    private String brand;
    // 需求型号 U_ICIN1.Modle
    @JsonProperty("Modle")
    private String modle;
    // 需求数量 U_ICIN1.DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // 需求封装 U_ICIN1.Package
    @JsonProperty("Package")
    private String packages;
    // 需求批次 U_ICIN1.Year
    @JsonProperty("Year")
    private String year;
    // 需求交期 U_ICIN1.Delivery
    @JsonProperty("U_Delivery")
    private String uDelivery;
    // 需求销项税代码 U_VatGroup
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 客户接受价格 U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    // 需求货币
    @JsonProperty("U_Currency")
    private String uCurrency;
    /**
     * @description 客户信息
     */
    // 客户行业领域代码 U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 客户性质名称 U_GroupCode
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
    // 客户等级名称 U_U_Level
    @JsonProperty("U_U_Level")
    private String uULevel;
    // 客户缩写代码
    @JsonProperty("U_ShortCode")
    private String uShortCode;
    /**
     * @description 采购报价信息
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
    // 供方报价 单价 T_ICIN1.U_QuoPrice
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 采购报价批次 U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 采购报价货币 T_ICIN1.U_QuoCurr
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    // 采购报价税率代码
    @JsonProperty("U_QuoVatGroup")
    private String uQuoVatGroup;
    // 采购报价税率税点
    @JsonProperty("U_QuoVatRate")
    private BigDecimal uQuoVatRate;
    // 供方交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;

    public String getUQuoDelivery() {
        if (uQuoDelivery != null) {
            return uQuoDelivery;
        } else {
            if (uDelivery != null) {
                String[] strList = uDelivery.replace("周", "").split("-");
                if (strList.length == 2) {
                    return (Integer.parseInt(strList[0]) + 2) + "-" + (Integer.parseInt(strList[1]) + 2) + "周";
                }else {
                    return "";
                }
            } else {
                return null;
            }
        }
    }

    /**
     * @description 其他
     */
    // 状态 U_ICIN1.U_Status
    @JsonProperty("U_Status")
    private String uStatus;
    // 销售备注 LineRemark
    @JsonProperty("LineRemark")
    private String lineRemark;
    // 无法报价 U_NoPrice
    @JsonProperty("U_NoPrice")
    private String uNoPrice;
    // 发送时间/录入时间 T_ICIN.InquiryDate
    @JsonProperty("DemandDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date demandDate;
    // 采购备注 T_ICIN1.U_Remark1
    @JsonProperty("U_Remark1")
    private String uRemark1;
    // 供方备注 T_ICIN1.U_QuoRemark
    @JsonProperty("U_QuoRemark")
    private String uQuoRemark;
    // 起订量 T_ICIN1.MinQty
    @JsonProperty("U_MinQty")
    private Integer uMinQty;
    // 联系人 T_ICIN1.U_ContPerson
    @JsonProperty("U_ContPerson")
    private String uContPerson;
    // 电话 T_ICIN1.U_ContPhone
    @JsonProperty("U_ContPhone")
    private String uContPhone;
    // 地址 T_ICIN1.ContAddress
    @JsonProperty("U_ContAddress")
    private String uContAddress;
    // 邮箱 T_ICIN1.U_ContEmail
    @JsonProperty("U_ContEmail")
    private String uContEmail;
    // 标准包装 T_ICIN1.U_StanPackage
    @JsonProperty("U_StanPackage")
    private String uStanPackage;
    // 参考价格
    @JsonProperty("U_PrePrice")
    private BigDecimal uPrePrice;
    // 保密
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    /**
     * @description 失效时间
     * @resource U_ICIN1.ExpDate
     */
    @JsonProperty("ExpDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expDate;

    // 到期时间 InvalidDate 当距离到期时间超过24h时，显示距离到期时间天数，否则显示距离到期时间小时数；当超过过期时间超过24h时，显示超过到期时间天数，否则显示超过到期时间小时数
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
     * @description 销售员信息
     */
    // 销售员编号
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    // 销售员姓名 T_ICIN.U_UserName
    @JsonProperty("U_UserName")
    private String uUserName;
    // 销售部门名称 T_ICIN.U_DeptName
    @JsonProperty("U_DeptName")
    private String uDeptName;
    // 销售员等级
    @JsonProperty("U_SaleLevel")
    private String uSaleLevel;
    /**
     * @description 供应商信息
     */
    // 供应商代码 T_ICIN1.U_CardCode
    @JsonProperty("U_CardCode")
    private String uCardCode;
    //  供应商名称 T_ICIN1.U_CardName
    @JsonProperty("U_CardName")
    private String uCardName;
    // 采购报价供应商等级名称 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 供应商性质
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 重点报价
     */
    // 重点报价
    @JsonProperty("U_KeyPoint")
    private String uKeyPoint;
    // 重点询价说明 T_ICIN1.U_KeyRemark
    @JsonProperty("U_KeyRemark")
    private String uKeyRemark;
    // 标记为重点报价用户
    @JsonProperty("U_KeyUser")
    private Long uKeyUser;
    // 税率+币种
    @JsonProperty("CurVat")
    private String curVat;
}
