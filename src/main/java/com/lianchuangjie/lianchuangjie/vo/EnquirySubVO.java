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
    private Long DocEntry;
    // 行号-主键 U_ICIN1.LineNum
    @JsonProperty("LineNum")
    private Long LineNum;
    // 需求型号 U_ICIN1.Modle
    @JsonProperty("Modle")
    private String Modle;
    // 需求品牌 U_ICIN1.Brand
    @JsonProperty("Brand")
    private String Brand;
    // @description 需求数量 U_ICIN1.DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal DemandQty;
    // ECCN U_ICIN1.ECCN
    @JsonProperty("ECCN")
    private String ECCN;
    // 需求交期 U_ICIN1.Delivery
    @JsonProperty("Delivery")
    private String Delivery;
    // 需求批次 Year
    @JsonProperty("Year")
    private String Year;
    // 客户备注 U_ICIN1.CurRemark
    @JsonProperty("CurRemark")
    private String CurRemark;
    // 接受价格 U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal ExpectedPrice;
    // 最低报价 MinQuoPrice
    private BigDecimal MinQuoPrice;
    // 推荐报价 RecoPrice
    @JsonProperty("RecoPrice")
    private BigDecimal RecoPrice;
    // SuccRate 成单率
    private BigDecimal SuccRate;
    // 报价型号 U_ICIN1.QuoModle
    @JsonProperty("QuoModle")
    private String QuoModle;
    // 报价交期 U_ICIN1.SuoDelivery
    @JsonProperty("SuoDelivery")
    private String SuoDelivery;
    // 报价批次 U_ICIN1.SuoYear
    @JsonProperty("SuoYear")
    private String SuoYear;
    // 报价数量 U_ICIN1.SuoQuantity
    @JsonProperty("SuoQuantity")
    private BigDecimal SuoQuantity;
    // 销售报价单价 U_ICIN1.PriceAfVAT
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 供方单价 U_ICIN1.QuoPrice
    @JsonProperty("QuoPrice")
    private BigDecimal QuoPrice;
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
    private String SuoBuyerName;
    // 用采购报价的采购员编号 U_ICIN1.SuoBuyer
    @JsonProperty("SuoBuyer")
    private Long SuoBuyer;
    // 询价状态代码，B表示采购报价、C表示直接定价、D表示暂不处理、E表示24H报价 U_ICIN1.Status
    @JsonProperty("Status")
    private String Status;
    // 询价状态名称 U_ICIN1.ItemDescStatus
    @JsonProperty("ItemDescStatus")
    private String itemDescStatus;
    // 采购回复 COUNT(T_ICIN1.U_Status = 'Y')
    @JsonProperty("PurchaseReply")
    private Long PurchaseReply;
    // 报价日期 U_ICIN1.CheckINDateT
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CheckINDateT")
    private Date CheckINDateT;
    // 销售备注 U_ICIN1.LineRemark
    @JsonProperty("LineRemark")
    private String LineRemark;
    // 失效时间 U_ICIN1.ExpDate
    @JsonProperty("ExpDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ExpDate;
    // 是否保密标记 Secrecy
    @JsonProperty("Secrecy")
    private String Secrecy;

    @JsonProperty("MinQuoPrice")
    public BigDecimal getMinQuoPrice() {
        return BigDecimal.valueOf(1);
    }

    @JsonProperty("SuccRate")
    public BigDecimal getSuccRate() {
        return BigDecimal.valueOf(80);
    }
}
