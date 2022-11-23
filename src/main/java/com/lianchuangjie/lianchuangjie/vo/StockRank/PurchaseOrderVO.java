package com.lianchuangjie.lianchuangjie.vo.StockRank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 在途库存采购订单
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PurchaseOrderVO {
    // 订单日期
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date docDate;
    // 型号
    @JsonProperty("Dscription")
    private String dscription;
    // 品牌
    @JsonProperty("U_Brand")
    private String uBrand;
    // 在途库存数量
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    // 采购员编号
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    // 采购员姓名
    @JsonProperty("UserName")
    private String userName;
    // 单价
    @JsonProperty("U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;
    // 交货日期
    @JsonProperty("ShipDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date shipDate;
    // 订单完成情况
    @JsonProperty("LineStatus")
    private String lineStatus;
}
