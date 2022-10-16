package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 销售报价页面-采购订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabEnquiryPurchaseOrderVO {
    /**
     * @description 订单日期 DocDate
     * @resource T_ORDR.DocDate
     */
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    //采购员姓名 T_OUSI.UserName
    @JsonProperty("UserName")
    private String userName;
    // 采购部门名称 T_OCDP.Name
    @JsonProperty("DeptName")
    private String deptName;
    // 供应商名称 T_OPOR.CardName
    @JsonProperty("CardName")
    private String cardName;
    // 供应商等级 T_OPOR.U_CusLevel
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 供应商类型 T_OPOR.U_GroupName
    @JsonProperty("U_GroupName")
    private String uGroupName;
    // 型号 T_OPOR1.Dscription
    @JsonProperty("Dscription")
    private String dscription;
    // U_ECCN T_OPOR1.U_ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 品牌 T_OPOR1.U_Brand
    @JsonProperty("U_Brand")
    private String uBrand;
    // 要求批次 T_OPOR1.U_Batch
    @JsonProperty("U_Batch")
    private String uBatch;
    // 数量 T_OPOR1.Quantity
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 未清数量 T_OPOR1.OpenQty
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    // 订单类型 T_OPOR1.U_OrderType
    @JsonProperty("U_OrderType")
    private String uOrderType;
    // 币种 T_OPOR.DocCur
    @JsonProperty("DocCur")
    private String docCur;
    // 单价 T_OPOR1.Price
    @JsonProperty("Price")
    private BigDecimal price;
    // 税率文本 T_OVTG.Name
    @JsonProperty("U_VatName")
    private String uVatName;
    // 预计交期 T_OPOR1.ShipDate
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shipDate;
    // 备注 T_OPOR1.U_Remark
    @JsonProperty("U_Remark")
    private String uRemark;
    // 执行情况 T_OPOR1.LineStatus
    @JsonProperty("LineStatus")
    private String lineStatus;
}
