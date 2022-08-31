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
    // unit_price 云汉价
    @JsonProperty("unit_price")
    private Float unitPrice;
    // unit_price_date 云汉价时间
    @JsonProperty("unit_price_date")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date unitPriceDate;
    // cg_avg7 采购avg7
    @JsonProperty("cg_avg7")
    private Float cgAvg7;
    // cg_avg7 采购avg14
    @JsonProperty("cg_avg14")
    private Float cgAvg14;
    // cg_avg7 采购avg30
    @JsonProperty("cg_avg30")
    private Float cgAvg30;
    // xs_avg7 销售avg7
    @JsonProperty("xs_avg7")
    private Float xsAvg7;
    // xs_avg14 销售avg14
    @JsonProperty("xs_avg14")
    private Float xsAvg14;
    // xs_avg30 销售avg30
    @JsonProperty("xs_avg30")
    private Float xsAvg30;
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
    // kc_price14 库存定价(14天)
    @JsonProperty("kc_price14")
    private Float kcPrice14;
    // reference7 参考价格(14天)
    @JsonProperty("reference14")
    private String reference14;
    // kc_price30 库存定价(30天)
    @JsonProperty("kc_price30")
    private Float kcPrice30;
    // reference7 参考价格(30天)
    @JsonProperty("reference30")
    private String reference30;
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
    // quan_2w 2w内单价区间
    @JsonProperty("quan_2w")
    private String quan2w;
    // price_2w_5w 2w-5w单价
    @JsonProperty("price_2w_5w")
    private Float price2w5w;
    // quan_2w_5w 2w-5w单价区间
    @JsonProperty("quan_2w_5w")
    private String quan2w5w;
    // price_5w_10w 5w_10w单价
    @JsonProperty("price_5w_10w")
    private Float price5w10w;
    // quan_5w_10w 5w_10w单价区间
    @JsonProperty("quan_5w_10w")
    private String quan5w10w;
    // price_10w 10w+单价
    @JsonProperty("price_10w")
    private Float price10w;
    // quan_10w 10w+单价区间
    @JsonProperty("quan_10w")
    private String quan10w;
}
