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
 * @description 库存定价-销售报价
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabStockPriceEnquiryVO {
    // 销售确认报价日期
    @JsonProperty("CheckINDateT")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkINDateT;
    // 客户性质名称
    @JsonProperty("U_CusGroupCode")
    private String uCusGroupCode;
    // 销售员姓名
    @JsonProperty("UserName")
    private String userName;
    // 销售部门
    @JsonProperty("DeptName")
    private String deptName;
    // 型号
    @JsonProperty("QuoModle")
    private String quoModle;
    // 品牌
    @JsonProperty("QuoBrand")
    private String quoBrand;
    // 数量
    @JsonProperty("SuoQuantity")
    private BigDecimal suoQuantity;
    // 批次
    @JsonProperty("SuoYear")
    private String suoYear;
    // 币种
    @JsonProperty("U_DocCur")
    private String uDocCur;
    // 单价
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 税率 VatRate
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    // 报价交期 SuoDelivery
    @JsonProperty("SuoDelivery")
    private String suoDelivery;
}
