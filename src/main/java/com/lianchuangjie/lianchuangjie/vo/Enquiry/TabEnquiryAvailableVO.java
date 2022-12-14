package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * 有效货源YTab
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabEnquiryAvailableVO {
    // 报价单编号
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单内部行号
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 货源类型
    @JsonProperty("Resource")
    private String resource;
    // 报价型号
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    // 报价品牌
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    // 报价交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 报价数量 T_ICIN1.U_QuoQty
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty = BigDecimal.valueOf(0);
    // 质检标准 T_ICIN1.U_QCDesc
    @JsonProperty("U_QCDesc")
    private String uQCDesc;
    // 供应商等级 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 采购部门名称/货源 T_OCDP.Name
    @JsonProperty("Deptname")
    private String deptName;
    // 引用采购报价的采购员姓名 T_OUSI.UserName
    @JsonProperty("BuyerName")
    private String buyerName;
    // 用采购报价的采购员编号 T_ICIN1.U_Buyer
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 报价日期 T_ICIN1.U_QuoDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("U_QuoDate")
    private Date uQuoDate;
    // QuoState 是否询价
    @JsonProperty("QuoState")
    private String quoState;


    // 成单率
    @JsonProperty("TransactionRate1")
    private BigDecimal transactionRate1;
    public BigDecimal getTransactionRate1() {
        if (transactionRate1 != null) {
            return transactionRate1.setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        } else {
            return null;
        }
    }
    @JsonProperty("TransactionRate2")
    private BigDecimal transactionRate2;
    public BigDecimal getTransactionRate2() {
        if (transactionRate2 != null) {
            return transactionRate2.setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        } else {
            return null;
        }
    }
    // ExchangeRate
    @JsonProperty("ExchangeRate")
    private BigDecimal exchangeRate;
    // 最低利润率
    @JsonProperty("MinProfitMargin")
    private BigDecimal minProfitMargin;
    // 利润率1
    @JsonProperty("ProfitMargin1")
    private BigDecimal profitMargin1;
    // 利润率2
    @JsonProperty("ProfitMargin2")
    private BigDecimal profitMargin2;
    // 供方报价
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 推荐报价 RecoPrice
    @JsonProperty("RecoPrice1")
    private BigDecimal recoPrice1;
    public BigDecimal getRecoPrice1() {
        if (profitMargin1 != null & uQuoPrice != null & exchangeRate != null) {
            return uQuoPrice.multiply(profitMargin1).add(uQuoPrice).multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP); // 汇率转换
        } else {
            return null;
        }
    }
    // 推荐报价 RecoPrice
    @JsonProperty("RecoPrice2")
    private BigDecimal recoPrice2;
    public BigDecimal getRecoPrice2() {
        if (profitMargin2 != null & uQuoPrice != null & exchangeRate != null) {
            return uQuoPrice.multiply(profitMargin2).add(uQuoPrice).multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP); // 汇率转换
        } else {
            return null;
        }
    }
    // 最低报价 MinQuoPrice
    @JsonProperty("MinQuoPrice")
    private BigDecimal minQuoPrice;
    public BigDecimal getMinQuoPrice() {
        if (minProfitMargin != null & uQuoPrice != null & exchangeRate != null) {
            return uQuoPrice.multiply(minProfitMargin).add(uQuoPrice).multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP); // 汇率转换
        } else {
            return null;
        }
    }
    /**
     * 推荐报价算法需要的字段
     */
    // 需求型号
    @JsonProperty("Modle")
    private String modle;
    // 需求品牌
    @JsonProperty("Brand")
    private String brand;
    // 需求数量
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // 客户代码
    @JsonProperty("CardCode")
    private String cardCode;
    // 客户等级
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 客户类型
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
    // 客户行业
    @JsonProperty("U_DomainName")
    private String uDomainName;
    // 紧急程度
    @JsonProperty("UrgentType")
    private String urgentType;
    // 是否保密
    @JsonProperty("Secrecy")
    private String secrecy;
    // 重要程度
    @JsonProperty("KeyPoint")
    private String keyPoint;
    // 客户地区
    @JsonProperty("U_Region")
    private String uRegion;
    // ECCN
    @JsonProperty("ECCN")
    private String eccn;
}
