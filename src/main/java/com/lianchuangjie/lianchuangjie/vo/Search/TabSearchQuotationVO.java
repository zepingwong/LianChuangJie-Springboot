package com.lianchuangjie.lianchuangjie.vo.Search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 模糊搜索采购报价页面
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabSearchQuotationVO {
    /**
     * @description 采购报价日期 U_QuoDate
     * @resource T_ICIN1.U_QuoDate
     */
    @JsonProperty("U_QuoDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uQuoDate;
    /**
     * @description 负责采购员编号 U_Buyer
     * @resource T_ICIN1.U_Buyer
     */
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    /**
     * @description 采购员姓名 U_BuyerName
     * @resource 根据 T_ICIN1.U_Buyer 匹配 T_OUSI.UserSign 获取 T_OUSI.UserName AS U_BuyerName
     */
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    /**
     * @description 采购部门代码
     * @resource 根据 T_ICIN1.U_Buyer 匹配 T_OUSI.UserSign 获取 T_OUSI.DftDept
     */
    @JsonProperty("DftDept")
    private String dftDept;
    /**
     * @description 采购部门名称 U_DftDeptName
     * @resource 根据 T_OUSI.DftDept 匹配 T_OCDP.DeptCode 获取 T_OCDP.Name
     */
    @JsonProperty("DftDeptName")
    private String dftDeptName;
    /**
     * @description 采购报价供应商代码 U_CardCode
     * @resource T_ICIN1.U_CardCode
     */
    @JsonProperty("U_CardCode")
    private String uCardCode;
    /**
     * @description 采购报价供应商性质 U_QuoGroupCode
     * @resource T_ICIN1.U_QuoGroupCode
     */
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    /**
     * @description 采购报价供应商等级名称 U_QuoLevel
     * @resource T_ICIN1.U_CardCode 匹配 T_OCRD.CardCode 获得 T_OCRD.U_CusLevel
     */
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    /**
     * @description 价格类型 Status
     * @resource U_ICIN1.Status
     */
    @JsonProperty("Status")
    private String status;
    /**
     * @description 采购报价型号 U_QuoModle
     * @resource T_ICIN1.U_QuoModle
     */
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    /**
     * @description 采购报价ECCN U_ECCN
     * @resource T_ICIN1.U_ECCN
     */
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 采购报价品牌 T_ICIN1.U_QuoBrand
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    /**
     * @description 采购报价数量 U_QuoQty
     * @resource T_ICIN1.U_QuoQty
     */
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    /**
     * @description 采购报价货币 U_QuoCurr
     * @description T_ICIN1.U_QuoCurr
     */
    @JsonProperty("U_QuoCurr")
    private String uQuoCurr;
    /**
     * @description 单价 U_QuoPrice
     * @resource T_ICIN1.U_QuoPrice
     */
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    /**
     * @description 税率代码 U_QuoVatGroup
     * @resource T_ICIN1.U_QuoVatGroup
     */
    @JsonProperty("U_QuoVatGroup")
    private String uQuoVatGroup;
    /**
     * @description 税率文本 U_QuoVatName
     * @resource T_OVTG.Name
     */
    @JsonProperty("U_QuoVatName")
    private String uQuoVatName;
    // 税率税点 T_OVTG.Rate
    @JsonProperty("U_QuoVatRate")
    private BigDecimal uQuoVatRate;
    // 供方交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 采购备注 T_ICIN1.U_QuoExplain
    @JsonProperty("U_QuoExplain")
    private String uQuoExplain;
}
