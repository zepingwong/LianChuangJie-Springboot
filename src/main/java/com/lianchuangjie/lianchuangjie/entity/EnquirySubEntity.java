package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户询价子表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_ICIN1")
public class EnquirySubEntity {
    // 询价单编号-主键 U_ICIN1.DocEntry
    @TableField(value = "DocEntry")
    private Long docEntry;
    // 行号-主键 U_ICIN1.LineNum
    @TableField(value = "LineNum")
    private Long lineNum;
    // 关联型号ItemId相同 U_ICIN1.ItemId
    @TableField(value = "ItemId")
    private Long itemId;
    // 失效时间 U_ICIN1.ExpDate
    @TableField(value = "ExpDate")
    private Date expDate;
    // 询价状态代码，B表示采购报价、C表示直接定价、D表示暂不处理、E表示24H报价
    @TableField(value = "Status")
    private String status;
    // 询价状态名称
    @TableField(value = "ItemDescStatus")
    private String itemDescStatus;
    /**
     * @description 客户需求信息
     */
    // 需求型号 U_ICIN1.Modle
    @TableField(value = "Modle")
    private String modle;
    // 需求品牌 U_ICIN1.Brand
    @TableField(value = "Brand")
    private String brand;
    // 需求数量 U_ICIN1.DemandQty
    @TableField(value = "DemandQty")
    private BigDecimal demandQty;
    //  需求批次 Year
    @TableField(value = "Year")
    private String year;
    // 需求ECCN ECCN
    @TableField(value = "ECCN")
    private String eccn;
    // 需求交期 Delivery
    @TableField(value = "Delivery")
    private String delivery;
    // 需求封装
    @TableField(value = "Package")
    private String packages;
    // 接受价格 ExpectedPrice
    @TableField(value = "ExpectedPrice")
    private BigDecimal expectedPrice;
    // 客户备注 CurRemark
    @TableField(value = "CurRemark")
    private String curRemark;
    // 紧急程度 UrgentType N表示紧急、O表示正常
    @TableField(value = "UrgentType")
    private String urgentType;
    // 需求销项税代码 VatGroup
    @TableField(value = "VatGroup")
    private String vatGroup;
    // 销项税文本 VatName
    @TableField(value = "VatName")
    private String vatName;
    // 销项税税点 百分比
    @TableField(exist = false)
    private BigDecimal vatRate;
    /**
     * 采购
     */
    // 报价的采购员 Buyers
    @TableField(value = "Buyers")
    private String buyers;
    // 是否保密标记 Secrecy
    @TableField(value = "Secrecy")
    private String secrecy;
    // 引用采购报价货币 QuoCurr
    @TableField(value = "QuoCurr")
    private String quoCurr;
    // 引用采购报价税率 QuoVatGroup
    @TableField(value = "QuoVatGroup")
    private String quoVatGroup;
    // 引用采购报价单价 QuoPrice
    @TableField(value = "QuoPrice")
    private BigDecimal quoPrice;
    // 采购报价单编号 BaseEntry
    @TableField(value = "BaseEntry")
    private Long baseEntry;
    // 采购报价单行号-第几次报价 BaseLine
    @TableField(value = "BaseLine")
    private Long baseLine;
    // 引用用采购报价的采购员编号 SuoBuyer
    @TableField(value = "SuoBuyer")
    private Long suoBuyer;
    // 引用采购报价的采购员ID U_ICIN1.SuoBuyerName
    @TableField(value = "SuoBuyerName")
    private String suoBuyerName;
    // 采购部门名称/货源  T_OCRD.U_DftDeptName
    @TableField(exist = false)
    private String uDftDeptName;
    /**
     * @description 报价信息
     */
    // 报价型号 QuoModle
    @TableField(value = "QuoModle")
    private String quoModle;
    // 报价品牌
    @TableField(value = "QuoBrand")
    private String quoBrand;
    // 报价交期 SuoDelivery
    @TableField(value = "SuoDelivery")
    private String suoDelivery;
    // 报价批次 SuoYear
    @TableField(value = "SuoYear")
    private String suoYear;
    // 报价数量 SuoQuantity
    @TableField(value = "SuoQuantity")
    private BigDecimal suoQuantity;
    // 销售报价单价 PriceAfVAT
    @TableField(value = "PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 确认报价日期 CheckINDateT
    @TableField(value = "CheckINDateT")
    private Date checkINDateT;
    // 是否确认报价 CheckIN
    @TableField(value = "CheckIN")
    private String checkIN;
    // 预估价格
    @TableField(value = "PrePrice")
    private BigDecimal prePrice;
    // 交易货币
    @TableField(value = "Currency")
    private String currency;
    /**
     * 其他
     */
    // 销售备注 LineRemark
    @TableField(value = "LineRemark")
    private String lineRemark;
    // 物料编号
    @TableField(value = "ItemCode")
    private String itemCode;
    // 重点报价
    @TableField(value = "KeyPoint")
    private String keyPoint;
    // 重点报价说明
    @TableField(value = "KeyRemark")
    private String keyRemark;
    // 标记为重点报价用户
    @TableField(value = "KeyUser")
    private Long keyUser;
}
