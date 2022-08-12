package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户询价主表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_ICIN")
public class EnquiryMainEntity {
    // BOM单编号-主键 T_ICIN.DocEntry
    @TableId(type = IdType.AUTO, value = "DocEntry")
    private Long docEntry;
    // 制单人编号 T_ICIN.UserSign
    @TableField(value = "UserSign")
    private Long userSign;
    // 发送时间 CreateDate
    @TableField(fill = FieldFill.INSERT, value = "CreateDate")
    private Date createDate;
    // 更新时间 UpdateTime
    @TableField(fill = FieldFill.INSERT, value = "UpdateTime")
    private Date updateTime;
    // 询价日期 InquiryDate
    @TableField(fill = FieldFill.INSERT, value = "InquiryDate")
    private Date inquiryDate;
    // 失效时间上限 InvalidDateMax
    @TableField(exist = false)
    private Date invalidDateMax;
    // 失效时间下限 InvalidDateMin
    @TableField(exist = false)
    private Date invalidDateMin;
    // 单据类型代码
    @TableField(value = "TransType")
    private Integer transType = 34002;
    // U_Delivery
    @TableField(value = "U_Delivery")
    private String uDelivery;
    // 处理情况-报价次数 State
    @TableField(value = "State")
    private Integer state;
    // New
    @TableField(value = "New")
    private String New;
    // 询价来源 SourceType
    @TableField(value = "SourceType")
    private String sourceType;
    /**
     * 销售
     */
    // 销售员编号 T_ICIN.OwnerCode
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    // 销售员姓名 U_UserName
    @TableField(value = "U_UserName")
    private String uUserName;
    // 销售部门代码 DeptCode
    @TableField(value = "DeptCode")
    private String deptCode;
    // 销售部门名称 U_DeptName
    @TableField(value = "U_DeptName")
    private String uDeptName;
    // 单据状态 DocStatus O表示有效、Q表示无效
    @TableField(value = "DocStatus")
    private String docStatus;
    /**
     * 货币及税率
     */
    // 需求货币 U_DocCur
    @TableField(value = "U_DocCur")
    private String uDocCur;
    // 需求销项税率代码 U_VatGroup
    @TableField(value = "U_VatGroup")
    private String uVatGroup;
    // 需求税率文字描述
    @TableField(exist = false)
    private String uVatName;
    // 税点
    @TableField(exist = false)
    private BigDecimal uVatRate;
    /**
     * @description 客户信息
     */
    // 客户编号 CardCode
    @TableField(value = "CardCode")
    private String cardCode;
    // 客户名称 CardName
    @TableField(value = "CardName")
    private String cardName;
    // 需求客户性质名称 U_CusGroupCode
    @TableField(value = "U_CusGroupCode")
    private String uCusGroupCode;
    // 需求客户等级名称 U_CusLevel
    @TableField(value = "U_CusLevel")
    private String uCusLevel;
    // 需求客户行业领域名称 U_DomainName
    @TableField(value = "U_DomainName")
    private String uDomainName;
    // 需求客户区域名称 U_Region
    @TableField(value = "U_Region")
    private String uRegion;
    // 交易地点 U_TransaPlace
    @TableField(value = "U_TransaPlace")
    private String uTransaPlace;
}
