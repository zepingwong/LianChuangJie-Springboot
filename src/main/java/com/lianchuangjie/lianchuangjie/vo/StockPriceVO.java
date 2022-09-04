package com.lianchuangjie.lianchuangjie.vo;

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
public class StockPriceVO {
    // 当前日期 DocDate
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    // 库存日期 InDate
    @JsonProperty("InDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inDate;
    // 品名 FrgnName
    @JsonProperty("FrgnName")
    private String frgnName;
    // 品牌 Brand
    @JsonProperty("Brand")
    private String brand;
    // 型号 ItemName
    @JsonProperty("ItemName")
    private String itemName;
    // 原批次 U_Batch
    @JsonProperty("U_Batch")
    private String uBatch;
    // 批次 Batch
    @JsonProperty("Batch")
    private String batch;
    // 库存数量
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 库存类型 TypeCode
    @JsonProperty("TypeCode")
    private String typeCode;
    // 是否保密 U_Secrecy
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    // 库存成本价 U_Price
    @JsonProperty("U_Price")
    private Float uPrice;
    // 最近一次销售报价 LastSalePrice
    @JsonProperty("LastSalePrice")
    private Float lastSalePrice;
    // 最近一次销售报价时间 LastSaleDate
    @JsonProperty("LastSaleDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSaleDate;
    // 最近一次采购报价 LastPurchasePrice
    @JsonProperty("LastPurchasePrice")
    private Float lastPurchasePrice;
    // 最近一次采购报价时间 LastPurchaseDate
    @JsonProperty("LastPurchaseDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastPurchaseDate;
    // StockDays 库存天数
    @JsonProperty("StockDays")
    private String stockDays;
    // LastPricingTime 最近一次定价时间
    @JsonProperty("LastPricingTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastPricingTime;
    // 最近一次定价 LastPrice
    @JsonProperty("LastPrice")
    private Float lastPrice;
    // 是否人工修改 Modify
    @JsonProperty("Modify")
    private String modify;
    // kc_price7 库存定价(7天)
    @JsonProperty("kc_price7")
    private Float kcPrice7;
    // reference7 参考价格(7天)
    @JsonProperty("reference7")
    private String reference7;
    // kc_price 库存定价
    @JsonProperty("kc_price")
    private Float kcPrice;
    // reference7 参考价格
    @JsonProperty("reference")
    private String reference;
    // kc_price_final 最终库存定价
    @JsonProperty("kc_price_final")
    private Float kcPrice_final;
    // reference_final 最终参考价格
    @JsonProperty("reference_final")
    private String referenceFinal;
    // price_2w 2w内单价
    @JsonProperty("price_2w")
    private Float price2w;
    // price_2w_5w 2w-5w单价
    @JsonProperty("price_2w_5w")
    private Float price2w5w;
    // price_5w_10w 5w_10w单价
    @JsonProperty("price_5w_10w")
    private Float price5w10w;
    // price_10w 10w+单价
    @JsonProperty("price_10w")
    private Float price10w;
}
