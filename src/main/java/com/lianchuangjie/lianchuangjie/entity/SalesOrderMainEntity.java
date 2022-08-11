package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 销售订单主表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_ORDR")
public class SalesOrderMainEntity {
    /**
     * @description 单据编号 DocEntry
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description 单据类型代码 TransType
     */
    @TableField(value = "TransType")
    private Long transType;
    /**
     * @description 单据状态-O表示未完成、C表示已完成、Q表示已取消
     */
    @TableField(value = "DocStatus")
    private String docStatus;
    /**
     * @description 销售员编号 OwnerCode
     */
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    /**
     * @description 制单人编号 UserSign
     */
    @TableField(value = "UserSign")
    private Long userSign;
    /**
     * @description 制单时间 CreateDate
     */
    @TableField(value = "CreateDate")
    private Date createDate;
    /**
     * @description 订单日期 DocDate
     */
    @TableField(value = "DocDate")
    private Date docDate;
    /**
     * @description CardCode 客户代码
     */
    @TableField(value = "CardCode")
    private String cardCode;
    /**
     * @description 客户名称 CardName
     */
    @TableField(value = "CardName")
    private String cardName;
    /**
     * @description 客户等级 U_CusLevel
     */
    @TableField(value = "U_CusLevel")
    private String uCusLevel;
    /**
     * @description 客户类型 U_GroupName
     */
    @TableField(value = "U_GroupName")
    private String uGroupName;
    /**
     * @description 客户行业 U_GroupCode
     */
    @TableField(value = "U_GroupCode")
    private String uGroupCode;
    /**
     * @description 税率 VatGroup
     */
    @TableField(value = "VatGroup")
    private String vatGroup;
    /**
     * @description 税点 VatRate
     */
    @TableField(value = "VatRate")
    private BigDecimal vatRate;
    /**
     * @description 交易货币 DocCur
     */
    @TableField(value = "DocCur")
    private String docCur;
}
