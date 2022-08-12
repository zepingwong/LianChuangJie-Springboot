package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BomQueryConsInfoDTO {
    /**
     * @description 客户名称
     * @target T_ICIN.CardName
     */
    @NotBlank(message = "客户名称不能为空")
    @JsonProperty("CardName")
    private String cardName;
    /**
     * @description 客户代码
     * @target T_ICIN.CardCode
     */
    @NotBlank(message = "客户代码不能为空")
    @JsonProperty("CardCode")
    private String cardCode;
    /**
     * @description 批次 Year
     */
    @JsonProperty("Year")
    private String year;
    /**
     * @description 交易货币 T_ICIN.U_DocCur+T_ICIN.U_VatGroup
     * @target T_ICIN.U_DocCur 和 T_ICIN.U_VatGroup
     */
    @NotBlank(message = "交易货币不能为空")
    @JsonProperty("CurVat")
    private String curVat;
    /**
     * @description 业务合作伙伴性质代码
     */
    @NotBlank(message = "客户性质不能为空")
    @JsonProperty("GroupCode")
    private Integer groupCode;
    /**
     * @description 销项税代码
     * @target T_ICIN.U_VatGroup
     */
    @JsonProperty("VatGroup")
    private String vatGroup;
    /**
     * @description 交易货币 T_ICIN.U_DocCur
     * @target T_ICIN.U_DocCur
     */
    @JsonProperty("U_DocCur")
    private String uDocCur;
    /**
     * @description 交易地点
     * @target T_ICIN.U_TransaPlace
     */
    @JsonProperty("U_TransaPlace")
    private String uTransaPlace;
    /**
     * @description 客户地区代码 U_Region
     * @target T_ICIN.U_Region
     */
    @JsonProperty("U_Region")
    private Integer uRegion;
    /**
     * @description 客户地区名称 Domain
     */
    @JsonProperty("DoMain")
    private String doMain;
    /**
     * @description 客户类型
     * @target T_ICIN.U_GroupName
     */
    @JsonProperty("U_GroupName")
    private String uGroupName;
    /**
     * @description 客户等级代码
     * @target T_ICIN.U_CusLevel
     */
    @JsonProperty("U_Level")
    private Integer uLevel;
    /**
     * @description 客户等级名称
     */
    @JsonProperty("U_CurLevel")
    private String uCurLevel;
    /**
     * @description 客户行业代码
     */
    @JsonProperty("U_Industries")
    private String uIndustries;
    /**
     * @description 客户行业
     * @target T_ICIN.U_DomainName
     */
    @JsonProperty("U_DomainName")
    private String uDomainName;
    /**
     * @description 需求交期
     * @target T_ICIN.U_Delivery
     */
    @JsonProperty("U_Delivery")
    private String uDelivery;
}
