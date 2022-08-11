package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 采购订单主表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OPOR")
public class PurchaseOrderMainEntity {
    /**
     * @description 单据编号 DocEntry
     */
    @TableField(value = "DocEntry")
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 单据类型代码 TransType
     */
    @TableField(value = "TransType")
    @JsonProperty("TransType")
    private Long transType;
    /**
     * @description 单据状态-O表示未完成、C表示已完成、Q表示已取消
     */
    @TableField(value = "DocStatus")
    @JsonProperty("DocDate")
    private String docStatus;
    /**
     * @description CardCode 供应商代码
     */
    @TableField(value = "CardCode")
    @JsonProperty("CardCode")
    private String cardCode;
    /**
     * @description 供应商名称 CardName
     */
    @TableField(value = "CardName")
    @JsonProperty("CardName")
    private String cardName;
    /**
     * @description 货币 DocCur
     */
    @TableField(value = "DocCur")
    @JsonProperty("DocCur")
    private String docCur;
    /**
     * @description 销售员编号 OwnerCode
     */
    @TableField(value = "OwnerCode")
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    /**
     * @description 销售部门编号 DeptCode
     */
    @TableField(value = "DeptCode")
    @JsonProperty("DeptCode")
    private String deptCode;
    /**
     * @description 税率 VatGroup
     */
    @TableField(value = "VatGroup")
    @JsonProperty("VatGroup")
    private String vatGroup;
    /**
     * @description 订单日期 DocDate
     */
    @TableField(value = "DocDate")
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    /**
     * @description 税点 VatRate
     */
    @TableField(value = "VatRate")
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    /**
     * @description 供应商等级 U_CusLevel
     */
    @TableField(value = "U_CusLevel")
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    /**
     * @description 供应商类型 U_GroupName
     */
    @TableField(value = "U_GroupName")
    @JsonProperty("U_GroupName")
    private String uGroupName;
    /**
     * @description 订单类型 U_OrderType
     */
    @TableField(value = "U_OrderType")
    @JsonProperty("U_OrderType")
    private String uOrderType;
    /**
     * @description 供应商行业 U_GroupCode
     */
    @TableField(value = "U_GroupCode")
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
}
