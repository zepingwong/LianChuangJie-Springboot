package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_ICIN1")
public class QuotationEntity {
    // 单据编号-主键
    @TableField(value = "DocEntry")
    private Long docEntry;
    // LineNum 第几次报价
    @TableField(value = "LineNum")
    private Long lineNum;
    // ItemId 关联型号ItemId 相同
    @TableField(value = "ItemId")
    private Long itemId;
    /**
     * 需求信息
     */
    // 销售报价单编号 U_BaseEntry
    @TableField(value = "U_BaseEntry")
    private Long uBaseEntry;
    // 销售报价单内部编号 U_BaseLine
    @TableField(value = "U_BaseLine")
    private Long uBaseLine;
    // 询价日期 DemandDate
    @TableField(value = "DemandDate")
    private Date demandDate;
    // 需求型号 Modle
    @TableField(value = "Modle")
    private String modle;
    // 需求数量 DemandQty
    @TableField(value = "DemandQty")
    private BigDecimal demandQty;
    // 需求品牌 Brand
    @TableField(value = "Brand")
    private String brand;
    // 需求交期 U_Delivery
    @TableField(value = "U_Delivery")
    private String uDelivery;
    // 需求批次 Year
    @TableField(value = "Year")
    private String year;
    // U_ECCN
    @TableField(value = "U_ECCN")
    private String uEccn;
    // 预估价格/参考价格 U_PrePrice
    @TableField(value = "U_PrePrice")
    private BigDecimal uPrePrice;
    // 预估总价 U_PreTotal
    @TableField(value = "U_PreTotal")
    private BigDecimal uPreTotal;
    // 是否保密 U_Secrecy
    @TableField(value = "U_Secrecy")
    private String uSecrecy;
    // 接受价格 ExpectedPrice
    @TableField(value = "ExpectedPrice")
    private BigDecimal expectedPrice;
    // 重要程度 U_KeyPoint
    @TableField(value = "U_KeyPoint")
    private String uKeyPoint;
    // 状态 U_Status
    @TableField(value = "U_Status")
    private String uStatus;
    // 销售备注
    @TableField(value = "LineRemark")
    private String lineRemark;
    // U_KeyRemark 标记为重点询价原因说明；如果需要采购确认货源的“待确认”；如果是老客户（下过单）“”
    @TableField(value = "U_KeyRemark")
    private String uKeyRemark;
    /**
     * 采购报价信息
     */
    // 采购报价品牌 U_QuoBrand
    @TableField(value = "U_QuoBrand")
    private String uQuoBrand;
    // 采购报价型号 U_QuoModle
    @TableField(value = "U_QuoModle")
    private String uQuoModle;
    // 报价数量 U_QuoQty
    @TableField(value = "U_QuoQty")
    private BigDecimal uQuoQty;
    // 采购报价时间 U_QuoDate
    @TableField(fill = FieldFill.INSERT, value = "U_QuoDate")
    private Date uQuoDate;
    // 采购报价税率代码 U_QuoVatGroup
    @TableField(value = "U_QuoVatGroup")
    private String uQuoVatGroup;
    // 供方报价 U_QuoPrice
    @TableField(value = "U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 采购报价货币 U_QuoCurr
    @TableField(value = "U_QuoCurr")
    private String uQuoCurr;
    // 供方交期 U_QuoDelivery
    @TableField(value = "U_QuoDelivery")
    private String uQuoDelivery;
    // 采购报价批次 U_QuoYear
    @TableField(value = "U_QuoYear")
    private String uQuoYear;
    // 供方备注 U_QuoRemark
    @TableField(value = "U_QuoRemark")
    private String uQuoRemark;
    // 采购备注 U_Remark1
    @TableField(value = "U_Remark1")
    private String uRemark1;
    // 质检标准
    @TableField(value = "U_QCDesc")
    private String uQCDesc;
    // 无法报价
    @TableField(value = "UnableQuote")
    private String unableQuote;
    // 标准包装
    @TableField(value = "StanPackage")
    private String stanPackage;
    // 起订量
    @TableField(value = "MinQty")
    private Integer minQty;
    // 联系人
    @TableField(value = "ContPerson")
    private String contPerson;
    // 电话
    @TableField(value = "ContPhone")
    private String contPhone;
    // 地址
    @TableField(value = "ContAddress")
    private String contAddress;
    // 邮箱
    @TableField(value = "ContEmail")
    private String contEmail;
    // 负责采购员编号
    @TableField(value = "U_Buyer")
    private Long uBuyer;
    // 采购员姓名 U_BuyerName
    @TableField(exist = false)
    private String uBuyerName;
    // 采购部门代码
    @TableField(exist = false)
    private String uDftDept;
    // 询价部门名称 U_DeptCod
    @TableField(value = "U_DeptCod")
    private String uDeptCod;
    // 销售员编号
    @TableField(exist = false)
    private Long OwnerCode;
    // 销售员姓名
    @TableField(value = "UserName", exist = false)
    private String userName;
    // 销售员等级
    @TableField(value = "U_SaleLevel")
    private String uSaleLevel;
    // 销售部门编号
    @TableField(value = "U_DeptCod")
    private String uDeptCode;
    // 销售部门名称
    @TableField(exist = false)
    private String uDeptName;
    // 采购报价供应商代码 U_CardCode
    @TableField(value = "U_CardCode")
    private String uCardCode;
    // 采购报价供应商名称 U_CardName
    @TableField(value = "U_CardName")
    private String uCardName;
    // 采购报价供应商性质 U_QuoGroupCode
    @TableField(value = "U_QuoGroupCode")
    private String uQuoGroupCode;
    // 采购报价供应商等级名称 U_QuoLevel
    @TableField(value = "U_QuoLevel")
    private String uQuoLevel;
    // 供应商等级名称等级代码 U_Level
    @TableField(exist = false)
    private String U_Level;
    // 供应商性质名称 U_GroupName
    @TableField(exist = false)
    private String U_GroupName;
    // 询价状态 ItemDescStatus
    @TableField(exist = false)
    private String ItemDescStatus;
    // 报价单价 PriceAfVAT 存在表 U_ICIN1中
    @TableField(exist = false)
    private BigDecimal priceAfVAT;
    // 询价单位代码 CardCode
    @TableField(exist = false)
    private String cardCode;
    // 询价单位名称 CardName
    @TableField(exist = false)
    private String cardName;
    // 询价单位等级 CusLevel
    @TableField(exist = false)
    private String CusLevel;
    // 询价单位行业领域名称 DomainName
    @TableField(exist = false)
    private String uDomainName;
    // 客户行业领域代码
    @TableField(value = "U_Industries")
    private String uIndustries;
    // 客户等级名称
    @TableField(value = "U_U_Level")
    private String uULevel;
    // 客户性质名称
    @TableField(value = "U_GroupCode")
    private String uGroupCode;
    // 需求销项税代码
    @TableField(value = "U_VatGroup")
    private String uVatGroup;
    @TableField(value = "U_ShortCode")
    private String uShortCode;
    // 需求货币
    @TableField(value = "U_Currency")
    private String uCurrency;
}
