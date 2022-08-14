package com.lianchuangjie.lianchuangjie.entity;

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
    /**
     * @description 单据编号-主键
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description BOM单编号 U_BaseEntry
     */
    @TableField(value = "U_BaseEntry")
    private Long uBaseEntry;
    /**
     * @description BOM单内部编号 U_BaseLine
     */
    @TableField(value = "U_BaseLine")
    private Long uBaseLine;
    /**
     * @description LineNum 第几次报价
     */
    @TableField(value = "LineNum")
    private Long lineNum;
    /**
     * @description ItemId 关联型号ItemId 相同
     */
    @TableField(exist = false)
    private Long itemId;
    /**
     * @description 询价日期 DemandDate
     */
    @TableField(value = "DemandDate")
    private Date demandDate;
    /**
     * @description 需求型号 Modle
     */
    @TableField(value = "Modle")
    private String modle;
    /**
     * @description 需求数量 DemandQty
     */
    @TableField(value = "DemandQty")
    private BigDecimal demandQty;
    /**
     * @description 需求品牌 Brand
     */
    @TableField(exist = false)
    private String brand;
    /**
     * @description 采购报价品牌 U_QuoBrand
     */
    @TableField(value = "U_QuoBrand")
    private String uQuoBrand;


    /**
     * @description 需求交期 U_Delivery
     */
    @TableField(value = "U_Delivery")
    private String uDelivery;
    /**
     * @description 批次 Year
     */
    @TableField(value = "Year")
    private String year;
    /**
     * @description U_ECCN
     */
    @TableField(value = "U_ECCN")
    private String uEccn;
    /**
     * @description 币种 U_Currency
     */
    @TableField(value = "U_Currency")
    private String uCurrency;
    /**
     * @description 采购报价税率 U_QuoVatGroup
     */
    @TableField(value = "U_QuoVatGroup")
    private String uQuoVatGroup;
    /**
     * @description 单价 U_PrePrice
     */
    @TableField(value = "U_PrePrice")
    private BigDecimal uPrePrice;
    /**
     * @description 总价 U_PreTotal
     */
    @TableField(value = "U_PreTotal")
    private BigDecimal uPreTotal;

    /**
     * @description 是否保密 U_Secrecy
     */
    @TableField(value = "U_Secrecy")
    private String uSecrecy;
    /**
     * @description 接受价格 ExpectedPrice
     */
    @TableField(value = "ExpectedPrice")
    private BigDecimal expectedPrice;
    /**
     * @description 重要程度 U_KeyPoint
     */
    @TableField(value = "U_KeyPoint")
    private String uKeyPoint;
    /**
     * @description 状态 U_Status
     */
    @TableField(value = "U_Status")
    private String uStatus;
    /**
     * @description 采购报价型号 U_QuoModle
     */
    @TableField(value = "U_QuoModle")
    private String uQuoModle;
    /**
     * @description 报价数量 U_QuoQty
     */
    @TableField(value = "U_QuoQty")
    private BigDecimal uQuoQty;
    /**
     * @description 采购报价时间 U_QuoDate
     */
    @TableField(value = "U_QuoDate")
    private Date uQuoDate;
    /**
     * @description 供方报价 U_QuoPrice
     */
    @TableField(value = "U_QuoPrice")
    private BigDecimal uQuoPrice;
    /**
     * @description 采购报价货币 U_QuoCurr
     */
    @TableField(value = "U_QuoCurr")
    private String uQuoCurr;
    /**
     * @description 供方交期 U_QuoDelivery
     */
    @TableField(value = "U_QuoDelivery")
    private String uQuoDelivery;
    /**
     * @description 采购报价批次 U_QuoYear
     */
    @TableField(value = "U_QuoYear")
    private String uQuoYear;
    /**
     * @description 供方备注 U_QuoRemark
     */
    @TableField(value = "U_QuoRemark")
    private String uQuoRemark;
    /**
     * @description 采购备注 U_Remark1
     */
    @TableField(value = "U_Remark1")
    private String uRemark1;
    /**
     * @description
     */
    @TableField(value = "U_QCDesc")
    private String uQCDesc;
    /**
     * @description
     */
    @TableField(value = "LineRemark")
    private String lineRemark;
    /**
     * @description U_KeyRemark 标记为重点询价原因说明
     */
    @TableField(value = "U_KeyRemark")
    private String uKeyRemark;

    /**
     * @description 无法报价
     */
    @TableField(value = "UnableQuote")
    private String unableQuote;
    /**
     * @description 标准包装
     */
    @TableField(value = "StanPackage")
    private String stanPackage;
    /**
     * @description 起订量
     */
    @TableField(value = "MinQty")
    private Integer minQty;
    /**
     * @description 联系人
     */
    @TableField(value = "ContPerson")
    private String contPerson;
    /**
     * @description 电话
     */
    @TableField(value = "ContPhone")
    private String contPhone;
    /**
     * @description 地址
     */
    @TableField(value = "ContAddress")
    private String contAddress;
    /**
     * @description 邮箱
     */
    @TableField(value = "ContEmail")
    private String contEmail;
    /**
     * @description 库存数量 Quantity
     * @resource 根据T_ICIN1.Modle(需求型号)和T_ICIN1.Year(需求批次) 匹配 T_OBTN.ItemName和T_OBTN.U_Batch 获取 T_OBTN.AbsEntry，通过T_OBTN.AbsEntry匹配T_OBTQ.MdAbsEntry获取T_OBTQ.Quantity
     */
    @TableField(exist = false)
    private BigDecimal Quantity;
    /**
     * @description 库存备注 U_Remark
     * @resource 根据型号和批次 匹配 T_OBTN的ItemName和U_Batch 获取 U_Remark
     */
    @TableField(exist = false)
    private String U_Remark;
    /**
     * @description 负责采购员编号 U_Buyer
     */
    @TableField(value = "U_Buyer")
    private Long uBuyer;
    /**
     * @description 采购员姓名 U_BuyerName
     * @resource 根据 T_ICIN1.U_Buyer 匹配 T_OUSI.UserSign 获取 T_OUSI.UserName AS U_BuyerName
     */
    @TableField(exist = false)
    private String uBuyerName;
    /**
     * @description 采购部门代码
     */
    @TableField(exist = false)
    private String uDftDept;
    /**
     * @description 采购部门名称 U_DftDeptName
     */
    @TableField(exist = false)
    private String uDftDeptName;
    /**
     * @description 销售员编号
     * @resource 根据 T_ICIN1.DocEntry 匹配 T_ICIN.DocEntry 获取 T_ICIN.OwnerCode
     */
    @TableField(exist = false)
    private Long OwnerCode;
    /**
     * @description 销售员姓名
     * @resource 根据 T_ICIN.OwnerCode 匹配 T_OUSI.UserSign 获取 T_OUSI.UserName
     */
    @TableField(exist = false)
    private String UserName;
    /**
     * @description 销售部门编号
     */
    @TableField(value = "U_DeptCod")
    private String U_DeptCode;
    /**
     * @description 销售部门名称
     * @resource 根据 T_OUSI.DftDept 匹配 T_OCDP.DeptCode 获取 T_OCDP.Name AS U_DeptName
     */
    @TableField(exist = false)
    private String U_DeptName;
    /**
     * @description 采购报价供应商代码 U_CardCode
     */
    @TableField(value = "U_CardCode")
    private String uCardCode;
    /**
     * @description 采购报价供应商名称 U_CardName
     * @resource T_ICIN1.CardName
     */
    @TableField(value = "U_CardName")
    private String uCardName;
    /**
     * @description 采购报价供应商性质 U_QuoGroupCode
     * @resource T_ICIN1.U_QuoGroupCode
     */
    @TableField(value = "U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 采购报价供应商等级名称 U_QuoLevel
     * @resource T_ICIN1.U_QuoLevel
     */
    @TableField(value = "U_QuoLevel")
    private String uQuoLevel;
    /**
     * @description 供应商等级名称等级代码 U_Level
     * @resource T_ICIN1.U_CardCode 匹配 T_OCRD.CardCode 获得 T_OCRD.U_Level
     */
    @TableField(exist = false)
    private String U_Level;
    /**
     * @description 供应商性质名称 U_GroupName
     */
    @TableField(exist = false)
    private String U_GroupName;
    /**
     * @description 询价状态 ItemDescStatus
     */
    @TableField(exist = false)
    private String ItemDescStatus;
    /**
     * @description 报价单价 PriceAfVAT 存在表 U_ICIN1中
     */
    @TableField(exist = false)
    private BigDecimal priceAfVAT;
    /**
     * @description 询价单位代码 CardCode
     */
    @TableField(exist = false)
    private String cardCode;
    /**
     * @description 询价单位名称 CardName
     */
    @TableField(exist = false)
    private String cardName;
    /**
     * @description 询价单位等级 CusLevel
     */
    @TableField(exist = false)
    private String CusLevel;

    /**
     * @description 询价单位行业领域名称 DomainName
     */
    @TableField(exist = false)
    private String DomainName;
    /**
     * @description 询价单位性质名称 GroupName
     */
    @TableField(exist = false)
    private String GroupName;
}
