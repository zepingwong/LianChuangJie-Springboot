package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquirySubVO {
    /**
     * 需求信息
     */
    // 询价单编号-主键 U_ICIN1.DocEntry
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 行号-主键 U_ICIN1.LineNum
    @JsonProperty("LineNum")
    private Long lineNum;
    // 需求型号 U_ICIN1.Modle
    @JsonProperty("Modle")
    private String modle;
    // 需求品牌 U_ICIN1.Brand
    @JsonProperty("Brand")
    private String brand;
    // @description 需求数量 U_ICIN1.DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // ECCN U_ICIN1.ECCN
    @JsonProperty("ECCN")
    private String eccn;
    // 需求交期 U_ICIN1.Delivery
    @JsonProperty("Delivery")
    private String delivery;
    // 需求批次 Year
    @JsonProperty("Year")
    private String year;
    // 客户备注 U_ICIN1.CurRemark
    @JsonProperty("CurRemark")
    private String curRemark;
    // 接受价格 U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    // 询价状态名称 U_ICIN1.ItemDescStatus
    @JsonProperty("ItemDescStatus")
    private String itemDescStatus;
    // 失效时间 U_ICIN1.ExpDate
    @JsonProperty("ExpDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expDate;
    // 是否保密标记 Secrecy
    @JsonProperty("Secrecy")
    private String secrecy;
    /**
     * 报价信息
     */
    // 报价单编号
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单内部行号
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 报价品牌
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    // 报价型号 T_ICIN1.U_QuoModle
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    // 报价交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 报价数量 T_ICIN1.U_QuoQty
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty = BigDecimal.valueOf(0);
    // 供方单价报价价格,人民币不含税 T_ICIN1.U_QuoPrice
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 供应商等级 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 质检标准 T_ICIN1.U_QCDesc
    @JsonProperty("U_QCDesc")
    private String uQCDesc;
    // 采购部门名称/货源 T_OCDP.Name
    @JsonProperty("DeptName")
    private String deptName;
    // 引用采购报价的采购员姓名 T_OUSI.UserName
    @JsonProperty("BuyerName")
    private String buyerName;
    // 用采购报价的采购员编号 T_ICIN1.U_Buyer
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 询价状态代码，B表示采购报价、C表示直接定价、D表示暂不处理、E表示24H报价 U_ICIN1.Status
    @JsonProperty("Status")
    private String status;
    // 报价日期 T_ICIN1.U_QuoDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("U_QuoDate")
    private Date uQuoDate;
    // 采购报价税率代码
    @JsonProperty("U_QuoVatGroup")
    private String uQuoVatRate;
    /**
     * 销售报价
     */
    // 销售报价单价 U_ICIN1.PriceAfVAT
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 销售备注 U_ICIN1.LineRemark
    @JsonProperty("LineRemark")
    private String lineRemark;
    // 是否下单
    @JsonProperty("IsOrdered")
    private String isOrdered;
    // 货源属性
    @JsonProperty("IsSpare")
    private String isSpare;
    // QuoState 是否询价
    @JsonProperty("QuoState")
    private String quoState;
    // ExchangeRate
    @JsonProperty("ExchangeRate")
    private BigDecimal exchangeRate;

    /**
     * 智能报价算法
     */
    // 客户代码
    @JsonProperty("CardCode")
    private String cardCode;
    // U_CusGroupCode
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
    @JsonProperty("U_DomainName")
    private String uDomainName;
    @JsonProperty("U_Region")
    private String uRegion;
    // 成单率
    @JsonProperty("TransactionRate")
    private BigDecimal transactionRate;
    private BigDecimal getTransactionRate() {
        if (transactionRate != null) {
            return transactionRate.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        } else {
            return null;
        }
    }
    // 最低利润率
    @JsonProperty("MinProfitMargin")
    private BigDecimal minProfitMargin;
    // 利润率
    @JsonProperty("ProfitMargin")
    private BigDecimal profitMargin;
    // 推荐报价 RecoPrice
    @JsonProperty("RecoPrice")
    private BigDecimal recoPrice;
    public BigDecimal getRecoPrice() {
        if (profitMargin != null & uQuoPrice != null & exchangeRate != null) {
            return uQuoPrice.multiply(profitMargin).multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP); // 汇率转换
        } else {
            return null;
        }
    }
    // 最低报价 MinQuoPrice
    @JsonProperty("MinQuoPrice")
    private BigDecimal minQuoPrice;
    public BigDecimal getMinQuoPrice() {
        if (minProfitMargin != null & uQuoPrice != null) {
            return uQuoPrice.multiply(minProfitMargin).multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP); // 汇率转换
        } else {
            return null;
        }
    }
}
