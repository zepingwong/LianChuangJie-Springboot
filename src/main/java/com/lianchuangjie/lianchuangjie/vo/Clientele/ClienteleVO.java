package com.lianchuangjie.lianchuangjie.vo.Clientele;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 业务合作伙伴信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClienteleVO {
    // 业务合作伙伴代码-主键 CardCode
    @JsonProperty("CardCode")
    private String cardCode;
    // 业务合作伙伴名称 CardName
    @JsonProperty("CardName")
    private String cardName;
    // 业务合作伙伴简称 ShortName
    @JsonProperty("ShortName")
    private String shortName;
    // 业务合作伙伴所属人编号 OwnerCode
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    // 业务合作伙伴所属人姓名 OwnerName
    @JsonProperty("OwnerName")
    private String ownerName;
    // U_Level
    @JsonProperty("U_Level")
    private Integer uLevel;
    // 业务合作伙伴等级名称 U_OHDJ.Level
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 业务合作伙伴区域代码 U_Region
    @JsonProperty("U_Region")
    private Integer uRegion;
    // 客户区域名称 U_OADD.DoMain
    @JsonProperty("DoMain")
    private String doMain;
    // 业务合作伙伴行业领域代码
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 业务合作伙伴行业领域名称
    @JsonProperty("U_DomainName")
    private String uDomainName;
    // 业务合作伙伴性质代码 T_OCRD.GroupCode
    @JsonProperty("GroupCode")
    private Integer groupCode;
    // 业务合作伙伴性质简称
    @JsonProperty("U_ShortName")
    private String uShortName;
    // 业务合作伙伴性质名称 T_OCRG.Name
    @JsonProperty("U_GroupName")
    private String uGroupName;
    // 业务合作伙伴可交易货币 Currency
    @JsonProperty("Currency")
    private String currency;
    // 业务合作伙伴默认货币 TransCurr
    @JsonProperty("TransCurr")
    private String transCurr;
    // 业务合作伙伴默认税率 VatGroup
    @JsonProperty("VatGroup")
    private String vatGroup;
    // 税率名称
    @JsonProperty("VatName")
    private String vatName;
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    // Currency+VatGroup+VatRate
    @JsonProperty("CurVat")
    private String curVat;
    // 业务合作伙伴所属部门编号 DeptCode
    @JsonProperty("DeptCode")
    private String deptCode;
    // 业务合作伙伴所属部门名称 U_DeptName
    @JsonProperty("U_DeptName")
    private String uDeptName;
    // 业务合作伙伴标记-C表示客户、S表示供应商
    @JsonProperty("CardType")
    private String cardType;
    // 业务合作伙伴创建时间 CreateDate
    @JsonProperty("CreateDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    // U_CardStatus = 'Y' 表示该客户第一次询价
    @JsonProperty("U_CardStatus")
    private String uCardStatus;
    // OldCustomer 是否下过单, 下过单为老客户
    @JsonProperty("OldCustomer")
    private String oldCustomer;
}
