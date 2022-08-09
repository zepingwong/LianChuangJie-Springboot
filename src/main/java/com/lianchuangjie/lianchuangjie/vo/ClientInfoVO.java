package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 客户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClientInfoVO {
    // 业务合作伙伴代码-主键 CardCode
    @JsonProperty("CardCode")
    private String CardCode;
    // 业务合作伙伴名称 CardName
    @JsonProperty("CardName")
    private String CardName;
    // 业务合作伙伴简称 ShortName
    @JsonProperty("ShortName")
    private String ShortName;
    // 业务合作伙伴所属人编号 OwnerCode
    @JsonProperty("OwnerCode")
    private Long OwnerCode;
    // U_Level
    @JsonProperty("U_Level")
    private Integer uLevel;
    // 业务合作伙伴等级名称 U_CusLevel
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 业务合作伙伴区域代码 U_Region
    @JsonProperty("U_Region")
    private Integer uRegion;
    // 客户区域名称
    @JsonProperty("DoMain")
    private String DoMain;
    // 业务合作伙伴性质代码
    @JsonProperty("GroupCode")
    private Integer GroupCode;
    // 业务合作伙伴性质名称 U_GroupName
    @JsonProperty("U_GroupName")
    private String uGroupName;
    // 业务合作伙伴行业领域代码 U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 业务合作伙伴行业领域名称 U_DomainName
    @JsonProperty("U_DomainName")
    private String uDomainName;
    // 业务合作伙伴可交易货币 Currency
    @JsonProperty("Currency")
    private String Currency;
    // 业务合作伙伴默认货币 TransCurr
    @JsonProperty("TransCurr")
    private String TransCurr;
    // 业务合作伙伴默认税率 VatGroup
    @JsonProperty("VatGroup")
    private String VatGroup;
    // Currency+VatGroup
    @JsonProperty("CurVat")
    private String CurVat;
    // 业务合作伙伴所属部门编号 DeptCode
    @JsonProperty("DeptCode")
    private String DeptCode;
    // 业务合作伙伴所属部门名称 U_DeptName
    @JsonProperty("U_DeptName")
    private String uDeptName;
    // 业务合作伙伴标记-C表示客户、S表示供应商
    @JsonProperty("CardType")
    private String CardType;
    // 业务合作伙伴创建时间 CreateDate
    @JsonProperty("CreateDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreateDate;
}
