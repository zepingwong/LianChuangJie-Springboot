package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 销售订单子表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_ORDR1")
public class SalesOrderSubEntity {
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 行状态 LineStatus
     */
    @JsonProperty("LineStatus")
    private String lineStatus;
    /**
     * 发货仓库代码 WhsCode
     */
    @JsonProperty("WhsCode")
    private String whsCode;
    /**
     * @description 物料编号 ItemCode
     */
    @JsonProperty("ItemCode")
    private String itemCode;
    /**
     * @description 品牌 U_Brand
     */
    @JsonProperty("U_Brand")
    private String uBrand;
    /**
     * @description 品牌名称 U_BrandName
     */
    @JsonProperty("U_BrandName")
    private String uBrandName;
    /**
     * @description 型号 Dscription
     */
    @JsonProperty("Dscription")
    private String dscription;
    /**
     * @description 要求批次 U_Batch
     */
    @JsonProperty("U_Batch")
    private String uBatch;
    /**
     * @description 订单数量 Quantity
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    /**
     * @description 未交数量 OpenQty
     */
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    /**
     * @description ECCN
     */
    @JsonProperty("U_ECCN")
    private String uEccn;
    /**
     * @description U_Remark 备注
     */
    @JsonProperty("U_Remark")
    private String uRemark;
    /**
     * @description 是否保密 U_Secrecy
     */
    @JsonProperty("U_Secrecy")
    private String uSecrecy;

    /**
     * @description 币种 U_Currency
     */
    @JsonProperty("U_Currency")
    private String uCurrency;
    /**
     * @description 客户料号 U_CusItemCode
     */
    @JsonProperty("U_CusItemCode")
    private String uCusItemCode;
    /**
     * @description 客户型号 U_CusItemName
     */
    @JsonProperty("U_CusItemName")
    private String uCusItemName;
    /**
     * @description 预计交期 ShipDate
     */
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shipDate;

    /**
     * @description 税率代码 U_VatGroup
     */
    @JsonProperty("U_VatGroup")
    private String uVatGroup;
    /**
     * @description 含税单价
     */
    @JsonProperty("U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;

    /**
     * @description 关联询价单据编号 U_BaseEntry
     */
    @JsonProperty("U_BaseEntry")
    private Long uBaseEntry;

    /**
     * @description 关联询价单据行号 U_BaseLine
     */
    @JsonProperty("U_BaseLine")
    private Long uBaseLine;
}
