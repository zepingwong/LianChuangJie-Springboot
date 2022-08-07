package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 询价单主表信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryMainVO {
    // 询价单编号-主键 DocEntry
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 销售部门名称 U_DeptName
    @JsonProperty("U_DeptName")
    private String uDeptName;
    /**
     * 客户信息
     */
    // 客户编号 CardCode
    @JsonProperty("CardCode")
    private String CardCode;
    // 客户名称 CardName
    @JsonProperty("CardName")
    private String CardName;
    // 需求客户性质名称 U_CusGroupCode
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
    // 客户行业领域名称 U_DomainName
    @JsonProperty("U_DomainName")
    private String uDomainName;
    // 需求客户等级名称 U_CusLevel
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 交易地点 U_TransaPlace
    @JsonProperty("U_TransaPlace")
    private String uTransaPlace;
    /**
     * @description 需求信息
     */
    // 需求货币 Currency
    @JsonProperty("Currency")
    private String Currency;
    // 销售员姓名 U_UserName
    @JsonProperty("U_UserName")
    private String uUserName;
    // 销售员编号 OwnerCode
    @JsonProperty("OwnerCode")
    private Long OwnerCode;
    // 失效时间上限 InvalidDateMax
    @JsonProperty("InvalidDateMax")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date InvalidDateMax;
    // 失效时间下限 InvalidDateMin
    @JsonProperty("InvalidDateMin")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date InvalidDateMin;
    // 税率税点 U_VatRate
    @JsonProperty("U_VatRate")
    private BigDecimal uVatRate;
}
