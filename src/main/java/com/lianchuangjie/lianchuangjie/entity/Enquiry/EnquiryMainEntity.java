package com.lianchuangjie.lianchuangjie.entity.Enquiry;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 制单人编号 T_ICIN.UserSign
    @TableField(value = "UserSign")
    private Long userSign;
    // 发送时间 CreateDate
    @TableField(fill = FieldFill.INSERT, value = "CreateDate")
    private Date createDate;
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
    @TableField(value = "U_State")
    private Integer uState;
    // New
    @TableField(value = "U_New")
    private String uNew;
    // 询价来源 SourceType
    @TableField(value = "U_SourceType")
    private String uSourceType;
    // U_DocType
    @TableField(value = "U_DocType")
    private Integer uDocType;
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
    private String docStatus = "O";
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
    // 客户性质名称 U_CusGroupCode
    @TableField(value = "U_CusGroupCode")
    private String uCusGroupCode;
    // 需求客户等级名称 U_CusLevel
    @TableField(value = "U_CusLevel")
    private String uCusLevel;
    // 客户行业领域名称 U_DomainName
    @TableField(value = "U_DomainName")
    private String uDomainName;
    // 客户行业领域代码
    @TableField(value = "U_Industries")
    private String uIndustries;
    // 需求客户区域名称 U_Region
    @TableField(value = "U_Region")
    private String uRegion;
    // 交易地点 U_TransaPlace
    @TableField(value = "U_TransaPlace")
    private String uTransaPlace;
    // 客户简称代码
    @TableField(value = "U_ShortCode")
    private String uShortCode;
    // 是否为新客户
    @TableField(value = "U_CardStatus")
    private String uCardStatus;
    // 报价公司抬头
    @TableField(value = "U_FromCompany")
    private String uFromCompany;
    // 发件人姓名
    @TableField(value = "U_SenderName")
    private String uSenderName;
    // 发件人电话
    @TableField(value = "U_SenderTel")
    private String uSenderTel;
    // 收件人姓名
    @TableField(value = "U_RecipientName")
    private String uRecipientName;
    // 收件人电话
    @TableField(value = "U_RecipientTel")
    private String uRecipientTel;
    // 运费付款
    @TableField(value = "U_FreightPayment")
    private String uFreightPayment;
    // 付款方式
    @TableField(value = "U_PaymentMethod")
    private String uPaymentMethod;
    // 重要程度-无效字段
    @TableField(value = "U_UrgentType")
    private String uUrgentType = "O";
    // 无效字段
    @TableField(value = "U_OrderType")
    private String uOrderType = "SO";
}
