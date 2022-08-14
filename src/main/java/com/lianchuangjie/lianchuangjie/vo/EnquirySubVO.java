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
public class EnquirySubVO {
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
    private String Year;
    // 客户备注 U_ICIN1.CurRemark
    @JsonProperty("CurRemark")
    private String curRemark;
    // 接受价格 U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    // 推荐报价 RecoPrice
    @JsonProperty("RecoPrice")
    private BigDecimal recoPrice;
    // 报价型号 U_ICIN1.QuoModle
    @JsonProperty("QuoModle")
    private String quoModle;
    // 报价交期 U_ICIN1.SuoDelivery
    @JsonProperty("SuoDelivery")
    private String suoDelivery;
    // 报价批次 U_ICIN1.SuoYear
    @JsonProperty("SuoYear")
    private String suoYear;
    // 报价数量 U_ICIN1.SuoQuantity
    @JsonProperty("SuoQuantity")
    private BigDecimal suoQuantity;
    // 销售报价单价 U_ICIN1.PriceAfVAT
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 供方单价 U_ICIN1.QuoPrice
    @JsonProperty("QuoPrice")
    private BigDecimal quoPrice;
    // 供应商等级 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 质检标准 T_ICIN1.U_QCDesc
    @JsonProperty("U_QCDesc")
    private String uQCDesc;
    // 采购部门代码 T_OCRD.DeptCode
    @JsonProperty("U_DftDept")
    private String uDftDept;
    // 采购部门名称/货源  T_OCRD.U_DftDeptName
    @JsonProperty("U_DftDeptName")
    private String uDftDeptName;
    // 引用采购报价的采购员姓名 T_OUSI.UserName
    @JsonProperty("SuoBuyerName")
    private String suoBuyerName;
    // 用采购报价的采购员编号 U_ICIN1.SuoBuyer
    @JsonProperty("SuoBuyer")
    private Long suoBuyer;
    // 询价状态代码，B表示采购报价、C表示直接定价、D表示暂不处理、E表示24H报价 U_ICIN1.Status
    @JsonProperty("Status")
    private String status;
    // 询价状态名称 U_ICIN1.ItemDescStatus
    @JsonProperty("ItemDescStatus")
    private String itemDescStatus;
    // 采购回复 COUNT(T_ICIN1.U_Status = 'Y')
    @JsonProperty("PurchaseReply")
    private Long purchaseReply;
    // 报价日期 U_ICIN1.CheckINDateT
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CheckINDateT")
    private Date CheckINDateT;
    // 销售备注 U_ICIN1.LineRemark
    @JsonProperty("LineRemark")
    private String lineRemark;
    // 失效时间 U_ICIN1.ExpDate
    @JsonProperty("ExpDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expDate;
    // 是否保密标记 Secrecy
    @JsonProperty("Secrecy")
    private String secrecy;
    // 最低报价 MinQuoPrice
    @JsonProperty("MinQuoPrice")
    private BigDecimal minQuoPrice;
    public BigDecimal getMinQuoPrice() {
        return BigDecimal.valueOf(1);
    }
    // SuccRate 成单率
    @JsonProperty("SuccRate")
    private BigDecimal succRate;
    public BigDecimal getSuccRate() {
        return BigDecimal.valueOf(80);
    }
}
