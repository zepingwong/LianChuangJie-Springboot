package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.utils.validate.NotEqual;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquiryMatchHeadDTO {
    private UserEntity user = SessionUtil.getUser();
    // 交易地点 T_ICIN.U_TransaPlace
    @NotNull(message = "交易地点不能为空")
    @JsonProperty("U_TransaPlace")
    private String uTransaPlace;
    // 需求交期 T_ICIN.U_Delivery
    @JsonProperty("U_Delivery")
    private String uDelivery;
    // 询价来源 T_ICIN.U_SourceType
    @JsonProperty("U_SourceType")
    private String uSourceType;
    /**
     * 货币及税率
     */
    // 交易货币 T_ICIN.U_DocCur+T_ICIN.U_VatGroup
    @NotBlank(message = "交易货币不能为空")
    @NotEqual(patten = "##", message = "货币类型错误")
    @JsonProperty("CurVat")
    private String curVat;
    // 交易货币 T_ICIN.U_DocCur
    @JsonProperty("U_DocCur")
    private String uDocCur;
    // 销项税代码 T_ICIN.U_VatGroup
    @NotBlank(message = "销项税代码不能为空")
    @JsonProperty("VatGroup")
    private String uVatGroup;
    /**
     * @description 客户信息
     */
    // 客户行业领域名称 T_ICIN.U_DomainName
    @NotBlank(message = "客户行业名称不能为空")
    @JsonProperty("U_DomainName")
    private String uDomainName;
    // 客户行业领域代码
    @JsonAlias({"U_CusIndustries", "U_Industries"})
    private String uIndustries;
    // 客户等级代码

    // 客户等级名称  T_ICIN.U_CusLevel
    @NotBlank(message = "客户等级名称不能为空")
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 客户性质代码
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
    // 客户性质名称 T_ICIN.U_CusGroupCode
    @NotBlank(message = "客户性质不能为空")
    @JsonAlias({"U_CusGroupCode", "U_GroupName"})
    private String uCusGroupCode;
    // 贸易商/终端
    private String uCusGroup;

    public String getUCusGroup() {
        return Objects.equals(uCusGroupCode, "关系型贸易商") | Objects.equals(uCusGroupCode, "一般贸易商") | Objects.equals(uCusGroupCode, "其它") ? "贸易商" : "终端";
    }

    // 客户地区代码
    @NotNull(message = "客户地区不能为空")
    @JsonProperty("U_Region")
    private Integer regionCode;
    // 客户地区名称 T_ICIN.U_Region
    @NotNull(message = "客户地区不能为空")
    @JsonProperty("DoMain")
    private String uRegion;
    // 客户名称 T_ICIN.CardName
    @NotBlank(message = "客户名称不能为空")
    @JsonProperty("CardName")
    private String CardName;
    // 客户代码 T_ICIN.CardCode
    @NotBlank(message = "客户代码不能为空")
    @JsonProperty("CardCode")
    private String cardCode;
    // 单据重用字段 1表示客户需求 3表示客户长期需求 5表示期货价格需求 6表示竞价需求
    private Integer uDocType = 1;
    @JsonProperty("UserSign")
    private Long userSign = user.getUserSign();
    @JsonProperty("OwnerCode")
    private Long ownerCode = user.getUserSign();
    @JsonProperty("U_UserName")
    private String uUserName = user.getUserName();
    @JsonProperty("DeptCode")
    private String deptCode = user.getDftDept();
    @JsonProperty("U_DeptName")
    private String uDeptName = user.getDftDeptName();
    // 判断是否为老客户,只有下过单的才是老客户
    @JsonProperty("OldCustomer")
    private String oldCustomer;
    // T_ICIN.U_CardStatus = 'Y' 表示该客户第一次询价
    @JsonProperty("U_CardStatus")
    private String uCardStatus;
    // 重要程度-无效字段
    private String uUrgentType = "O";
    // 客户性质简称
    @JsonProperty("U_ShortName")
    private String uShortName;

    private String uShortCode;
    public String getUShortCode() {
        return  uRegion + " " + uDomainName + " " + uShortName + "-" + cardCode.replace("C", "");
    }
}
