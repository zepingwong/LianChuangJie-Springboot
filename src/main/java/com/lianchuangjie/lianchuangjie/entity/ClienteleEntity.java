package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OCRD")
public class ClienteleEntity {
    // 业务合作伙伴代码-主键 CardCode
    private String CardCode;
    // 业务合作伙伴名称 CardName
    private String CardName;
    // 业务合作伙伴简称 ShortName
    private String ShortName;
    // 业务合作伙伴所属人编号 OwnerCode
    private Long OwnerCode;
    // 业务合作伙伴等级代码 U_Level
    private Integer uLevel;
    // 业务合作伙伴等级名称 U_CusLevel
    private String uCusLevel;
    // 业务合作伙伴区域代码 U_Region
    private Integer uRegion;
    // 业务合作伙伴地区名称 U_OADD.DoMain
    @TableField(exist = false)
    private String DoMain;
    // 业务合作伙伴性质代码 GroupCode
    private Integer GroupCode;
    // 业务合作伙伴性质名称 U_GroupName
    private String uGroupName;
    // 业务合作伙伴行业领域代码 U_Industries
    private String uIndustries;
    // 业务合作伙伴行业领域名称 U_DomainName
    private String uDomainName;
    // 业务合作伙伴可交易货币 Currency
    private String Currency;
    // 业务合作伙伴默认货币 TransCurr
    private String TransCurr;
    // 业务合作伙伴默认税率 VatGroup
    private String VatGroup;
    // 业务合作伙伴所属部门编号 DeptCode
    private String DeptCode;
    // 业务合作伙伴所属部门名称 U_DeptName
    private String uDeptName;
    // 业务合作伙伴标记-C表示客户、S表示供应商 CardType
    private String CardType;
    // 业务合作伙伴创建时间 CreateDate
    private Date CreateDate;
    // Currency+VatGroup+VatRate
    @TableField(exist = false)
    private String CurVat;

}
