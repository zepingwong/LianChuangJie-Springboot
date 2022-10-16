package com.lianchuangjie.lianchuangjie.vo.StockPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 原始库存信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabStockPriceOriginVO {
    // 型号
    @JsonProperty("ItemName")
    private String itemName;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("StockDays")
    private BigDecimal stockDays;
    // 原批次
    @JsonProperty("U_Batch")
    private String uBatch;
    // 成本价
    @JsonProperty("U_Price")
    private BigDecimal uPrice;
    // 数量
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 保密
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    @JsonProperty("First")
    private BigDecimal first;
    @JsonProperty("Second")
    private BigDecimal second;
    @JsonProperty("Third")
    private BigDecimal third;
}
