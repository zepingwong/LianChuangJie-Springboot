package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabEnquirySalesOrderVO {
    /**
     * @description 订单日期 DocDate
     * @resource T_ORDR.DocDate
     */
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    // 销售员姓名 T_OUSI.UserName
    @JsonProperty("UserName")
    private String userName;
    // 销售部门名称 T_OCDP.Name
    @JsonProperty("DeptName")
    private String DeptName;
    // 客户名称 T_ORDR1.CardName
    @JsonProperty("CardName")
    private String cardName;
    // 客户性质 T_ORDR1.U_GroupCode
    @JsonProperty("U_GroupCode")
    private String uGroupCode;
    // 需求客户等级名称 T_ORDR1.U_CusLevel
    @JsonProperty("U_CusLevel")
    private String uCusLevel;
    // 需求客户行业领域名称 T_ORDR1.U_Industries
    @JsonProperty("U_Industries")
    private String uIndustries;
    // 是否保密标记 T_ORDR1.U_Secrecy
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    // 报价型号 T_ORDR1.Dscription
    @JsonProperty("Dscription")
    private String dscription;
    // 报价品牌 T_ORDR1.U_Brand
    @JsonProperty("U_Brand")
    private String uBrand;
    // 报价批次 T_ORDR1.U_Batch
    @JsonProperty("U_Batch")
    private String uBatch;
    /**
     * @description 订单数量 Quantity
     * @resource T_ORDR1.Quantity
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    /**
     * @description 未交数量 OpenQty
     * @resource T_ORDR1.OpenQty
     */
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    // U_ECCN T_ORDR1.U_ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 币种 T_ORDR.DocCur
    @JsonProperty("DocCur")
    private String docCur;
    // 税率文本 T_OVTG.Name
    @JsonProperty("U_VatName")
    private String uVatName;
    /**
     * @description 含税单价
     * @resource T_ORDR1.U_PriceAfVAT
     */
    @JsonProperty("U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;
    // 预计交期 T_ORDR1.ShipDate
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shipDate;
    // 备注 T_ORDR1.U_Remark
    @JsonProperty("U_Remark")
    private String uRemark;
}
