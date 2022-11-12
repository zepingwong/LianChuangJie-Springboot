package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotationSaveDTO {
    /**
     * @description 编号
     */
    // 报价单编号-主键 T_ICIN1.U_BaseEntry
    @NotNull(message = "报价单编号不能为空")
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 询价单编号-主键 T_ICIN1.U_BaseEntry
    @NotNull(message = "询价单编号不能为空")
    @JsonProperty("U_BaseEntry")
    private Long uBaseEntry;
    // 行号-主键 T_ICIN1.U_BaseLine
    @NotNull(message = "询价单行号不能为空")
    @JsonProperty("U_BaseLine")
    private Long uBaseLine;
    // 无法报价 T_ICIN1.UnableQuote
    @JsonProperty("UnableQuote")
    private String unableQuote;
    /**
     * @description 供应商
     */
    // 供应商代码 U_CardCode
    @NotBlank(message = "供应商代码不能为空")
    @JsonProperty("U_CardCode")
    private String uCardCode;
    // 供应商名称 T_ICIN1.U_CardName
    @NotBlank(message = "供应商名称不能为空")
    @JsonProperty("U_CardName")
    private String uCardName;
    // U_QuoGroupCode 采购报价供应商性质
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    // 采购报价供应商等级名称 U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    /**
     * @description 报价信息
     */
    // 报价型号 T_ICIN1.U_QuoModle
    @NotBlank(message = "报价型号不能为空")
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    // 采购报价数量 T_ICIN1.U_QuoQty
    @NotNull(message = "报价数量不能为空")
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    // 单价 T_ICIN1.U_QuoPrice
    @NotNull(message = "供方报价不能为空")
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 采购报价货币 T_ICIN1.U_QuoCurr
    @NotNull(message = "报价货币不能为空")
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    // 采购报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 供方交期 T_ICIN1.U_QuoDelivery
    @NotBlank(message = "供方交期不能为空")
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 采购报价税率代码 U_QuoVatGroup
    @JsonProperty("U_QuoVatGroup")
    private String uQuoVatGroup;
    // 采购报价品牌 U_QuoBrand
    @JsonProperty(value = "U_QuoBrand")
    private String uQuoBrand;
    /**
     * @description 其他
     */
    // 状态 T_ICIN1.U_Status N表示已保存，Y表示已回复
    @JsonProperty("U_Status")
    private String uStatus;
    // 起订量 T_ICIN1.MinQty
    @JsonProperty("U_MinQty")
    private Integer uMinQty;
    // 联系人 T_ICIN1.ContPerson
    @JsonProperty("U_ContPerson")
    private String uContPerson;
    // 电话 T_ICIN1.ContPhone
    @JsonProperty("U_ContPhone")
    private String uContPhone;
    // 地址 T_ICIN1.ContAddress
    @JsonProperty("U_ContAddress")
    private String uContAddress;
    // 邮箱 T_ICIN1.ContEmail
    @JsonProperty("U_ContEmail")
    private String uContEmail;
    // 标准包装 T_ICIN1.StanPackage
    @JsonProperty("U_StanPackage")
    private String uStanPackage;
    // 供方备注 T_ICIN1.U_QuoRemark
    @JsonProperty("U_QuoRemark")
    private String uQuoRemark;
    // 采购备注 T_ICIN1.U_Remark1
    @JsonProperty("U_Remark1")
    private String uRemark1;
    /**
     * 客户信息
     */
    // 客户行业领域代码 U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 客户等级
    @JsonProperty("U_U_Level")
    private String uULevel;
    // 需求销项税代码
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    // 客户性质名称
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
    // 客户简称代码
    @JsonProperty("U_ShortCode")
    private String uShortCode;
    /**
     * @description 客户需求
     */
    // 需求交期 U_Delivery
    @JsonProperty("U_Delivery")
    private String uDelivery;
    // 需求型号
    @JsonProperty("Modle")
    private String modle;
    // 需求品牌
    @JsonProperty("Brand")
    private String brand;
    // 需求批次 Year
    @JsonProperty("Year")
    private String year;
    // 需求货币
    @JsonProperty("U_Currency")
    private String uCurrency;
    // 需求数量 DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 预估价格/参考价格 U_PrePrice
    @JsonProperty("U_PrePrice")
    private BigDecimal uPrePrice;
    // 预估总价
    @JsonProperty("U_PreTotal")
    private BigDecimal uPreTotal;
    // 发送时间/录入时间 T_ICIN1.DemandDate
    @JsonProperty("DemandDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接参数
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date demandDate;
    // 保密
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    // 接受价格 ExpectedPrice U_ICIN1.ExpectedPrice
    @JsonProperty("ExpectedPrice")
    private BigDecimal expectedPrice;
    // 重点报价
    @JsonProperty(value = "U_KeyPoint")
    private String uKeyPoint;
    // 重点报价说明
    @JsonProperty(value = "U_KeyRemark")
    private String uKeyRemark;
    // 标记为重点报价用户
    @JsonProperty(value = "U_KeyUser")
    private Long uKeyUser;
    /**
     * @description 销售员
     */
    // 销售员等级
    @JsonProperty("U_SaleLevel")
    private String uSaleLevel;
    /**
     * 采购员信息
     */
    UserEntity user = SessionUtil.getUser();
    // 采购员编号
    private Long uBuyer = user.getUserSign();
    private String userName = user.getUserName();
    private String uDeptCod = user.getDftDeptName();
}
