package com.lianchuangjie.lianchuangjie.vo.StockPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 销售报价页面-采购订单TAB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabStockPricePurchaseOrderVO {
    /**
     * @description 订单日期 DocDate
     * @resource T_ORDR.DocDate
     */
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    // 采购员姓名 T_OUSI.UserName
    @JsonProperty("UserName")
    private String userName;
    // 采购部门编号 T_OCDP.Name
    @JsonProperty("DeptName")
    private String deptName;
    /**
     * @description 供应商名称 CardName
     * @resource T_OPOR.CardName
     */
    @JsonProperty("CardName")
    private String cardName;
    /**
     * @description 供应商等级 U_CusLevel
     */
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    /**
     * @description 供应商类型 U_GroupName
     */
    @JsonProperty("U_GroupName")
    private String uGroupName;
    /**
     * @description 型号 Dscription
     * @resource T_OPOR1.Dscription
     */
    @JsonProperty("Dscription")
    private String dscription;
    /**
     * @description U_ECCN
     */
    @JsonProperty("U_ECCN")
    private String uEccn;
    /**
     * @description 品牌 U_Brand
     */
    @JsonProperty("U_Brand")
    private String uBrand;
    /**
     * @description 要求批次 U_Batch
     */
    @JsonProperty("U_Batch")
    private String uBatch;
    /**
     * @description 数量 Quantity
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 币种 T_OPOR.DocCur
    @JsonProperty("DocCur")
    private String docCur;
    /**
     * @description 未清数量 OpenQty
     */
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    /**
     * @description 预计交期 ShipDate
     */
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shipDate;
    // 税率文本
    @JsonProperty("VatName")
    private String vatName;
    // 单价 T_OPOR1.Price
    @JsonProperty("Price")
    private BigDecimal price;
    // 执行情况 T_OPOR1.LineStatus
    @JsonProperty("LineStatus")
    private String lineStatus;
    // 订单类型 T_OPOR1.U_OrderType
    @JsonProperty("U_OrderType")
    private String uOrderType;
}
