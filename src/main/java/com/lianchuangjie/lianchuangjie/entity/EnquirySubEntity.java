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
    private Long DocEntry;
    // 行号-主键 U_ICIN1.LineNum
    private Long LineNum;
    // 关联型号ItemId相同 U_ICIN1.ExpDate
    private Long ItemId;
    // 失效时间 U_ICIN1.ExpDate
    private Date ExpDate;
    // 询价状态代码，B表示采购报价、C表示直接定价、D表示暂不处理、E表示24H报价
    private String Status;
    // 询价状态名称
    private String ItemDescStatus;
    /**
     * @description 客户需求信息
     */
    // 需求型号 U_ICIN1.Modle
    private String Modle;
    // 需求品牌 U_ICIN1.Brand
    private String Brand;
    // 需求数量 U_ICIN1.DemandQty
    private BigDecimal DemandQty;
    //  需求批次 Year
    private String year;
    // 需求ECCN ECCN
    private String ECCN;
    // 需求交期 Delivery
    private String Delivery;
    // 接受价格 ExpectedPrice
    private BigDecimal ExpectedPrice;
    // 客户备注 CurRemark
    private String CurRemark;
    // 重要程度
    private String KeyPoint;
    // 紧急程度 UrgentType N表示紧急、O表示正常
    private String UrgentType;
    // 需求销项税代码 VatGroup
    private String VatGroup;
    // 销项税文本 VatName
    private String VatName;
    // 销项税税点 百分比
    private BigDecimal VatRate;
    /**
     * 采购
     */
    // 报价的采购员 Buyers
    private String Buyers;
    // 是否保密标记 Secrecy
    private String Secrecy;
    // 引用采购报价货币 QuoCurr
    private String QuoCurr;
    // 引用采购报价税率 QuoVatGroup
    private String QuoVatGroup;
    // 引用采购报价单价 QuoPrice
    private BigDecimal QuoPrice;
    // 采购报价单编号 BaseEntry
    private Long BaseEntry;
    // 采购报价单行号-第几次报价 BaseLine
    private Long BaseLine;
    // 引用用采购报价的采购员编号 SuoBuyer
    private Long SuoBuyer;
    // 引用采购报价的采购员ID U_ICIN1.SuoBuyerName
    private String SuoBuyerName;
    // 采购部门名称/货源  T_OCRD.U_DftDeptName
    @TableField(exist = false)
    private String uDftDeptName;
    /**
     * @description 报价信息
     */
    // 报价型号 QuoModle
    private String QuoModle;
    // 报价品牌
    private String QuoBrand;
    // 报价交期 SuoDelivery
    private String SuoDelivery;
    // 报价批次 SuoYear
    private String SuoYear;
    // 报价数量 SuoQuantity
    private BigDecimal SuoQuantity;
    // 销售报价单价 PriceAfVAT
    private BigDecimal PriceAfVAT;
    // 确认报价日期 CheckINDateT
    private Date CheckINDateT;
    // 是否确认报价 CheckIN
    private String CheckIN;
    // 预估价格
    private BigDecimal PrePrice;
    // 交易货币
    private String Currency;
    /**
     * 其他
     */
    // 销售备注 LineRemark
    private String LineRemark;
    // 物料编号
    private String ItemCode;
}
