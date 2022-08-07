package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Long DocEntry;
    // 制单人编号 T_ICIN.UserSign
    private Long UserSign;
    // 发送时间 CreateDate
    private Date CreateDate = new Date();
    // 更新时间 UpdateTime
    private Date UpdateTime;
    // 询价日期 InquiryDate
    private Date InquiryDate = new Date();
    // 失效时间上限 InvalidDateMax
    @TableField(exist = false)
    private Date InvalidDateMax;
    // 失效时间下限 InvalidDateMin
    @TableField(exist = false)
    private Date InvalidDateMin;
    // 单据类型代码
    private Integer TransType = 34002;
    // U_Delivery
    private String uDelivery;
    // 处理情况-报价次数 State
    private Integer State;
    // New
    private String New;
    // 询价来源 SourceType
    private String SourceType;
    /**
     * 销售
     */
    // 销售员编号 T_ICIN.OwnerCode
    private Long OwnerCode;
    // 销售员姓名 U_UserName
    private String uUserName;
    // 销售部门代码 DeptCode
    private String DeptCode;
    // 销售部门名称 U_DeptName
    private String uDeptName;
    // 单据状态 DocStatus O表示有效、Q表示无效
    private String DocStatus;
    /**
     * 货币及税率
     */
    // 需求货币 U_DocCur
    private String uDocCur;
    // 需求销项税率代码 U_VatGroup
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
    private String CardCode;
    // 客户名称 CardName
    private String CardName;
    // 需求客户性质名称 U_CusGroupCode
    private String uCusGroupCode;
    // 需求客户等级名称 U_CusLevel
    private String uCusLevel;
    // 需求客户行业领域名称 U_DomainName
    private String uDomainName;
    // 需求客户区域名称 U_Region
    private String uRegion;
    // 交易地点 U_TransaPlace
    private String uTransaPlace;
}
