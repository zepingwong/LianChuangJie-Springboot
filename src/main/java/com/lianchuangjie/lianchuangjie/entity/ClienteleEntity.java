package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 业务合作伙伴表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OCRD")
public class ClienteleEntity {
    // 业务合作伙伴代码-主键 CardCode
    @TableField(value = "CardCode")
    private String cardCode;
    // 业务合作伙伴名称 CardName
    @TableField(value = "CardName")
    private String cardName;
    // 业务合作伙伴简称 ShortName
    @TableField(value = "ShortName")
    private String shortName;
    // 业务合作伙伴所属人编号 OwnerCode
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    // 业务合作伙伴等级代码 U_Level
    @TableField(value = "U_Level")
    private Integer uLevel;
    // 业务合作伙伴等级名称 U_CusLevel
    @TableField(value = "U_CusLevel")
    private String uCusLevel;
    // 业务合作伙伴区域代码 U_Region
    @TableField(value = "U_Region")
    private Integer uRegion;
    // 业务合作伙伴地区名称 U_OADD.DoMain
    @TableField(exist = false)
    private String doMain;
    // 业务合作伙伴性质代码 GroupCode
    @TableField(value = "GroupCode")
    private Integer groupCode;
    // 业务合作伙伴性质名称 U_GroupName
    @TableField(value = "U_GroupName")
    private String uGroupName;
    // 业务合作伙伴行业领域代码 U_Industries
    @TableField(value = "U_Industries")
    private String uIndustries;
    // 业务合作伙伴行业领域名称 U_DomainName
    @TableField(value = "U_DomainName")
    private String uDomainName;
    // 业务合作伙伴可交易货币 Currency
    @TableField(value = "Currency")
    private String currency;
    // 业务合作伙伴默认货币 TransCurr
    @TableField(value = "TransCurr")
    private String transCurr;
    // 业务合作伙伴默认税率 VatGroup
    @TableField(value = "VatGroup")
    private String vatGroup;
    // 业务合作伙伴所属部门编号 DeptCode
    @TableField(value = "DeptCode")
    private String deptCode;
    // 业务合作伙伴所属部门名称 U_DeptName
    @TableField(value = "U_DeptName")
    private String uDeptName;
    // 业务合作伙伴标记-C表示客户、S表示供应商 CardType
    @TableField(value = "CardType")
    private String cardType;
    // 业务合作伙伴创建时间 CreateDate
    @TableField(value = "CreateDate")
    private Date createDate;
    // Currency+VatGroup+VatRate
    @TableField(exist = false)
    private String curVat;
}
