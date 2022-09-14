package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("kc_now")
public class StockPriceEntity {
    // 当前日期 DocDate
    @TableField(value = "DocDate")
    private Date docDate;
    // 库存日期 InDate
    @TableField(value = "InDate")
    private Date inDate;
    // 品名 FrgnName
    @TableField(value = "FrgnName")
    private String frgnName;
    // 品牌 Brand
    @TableField(value = "Brand")
    private String brand;
    // 型号 ItemName
    @TableField(value = "ItemName")
    private String itemName;
    // 原批次 U_Batch
    @TableField("U_Batch")
    private String uBatch;
    // 批次 Batch
    @TableField("Batch")
    private String batch;
    // 库存数量
    @TableField("Quantity")
    private BigDecimal quantity;
    // 库存类型 TypeCode
    @TableField("TypeCode")
    private String typeCode;
    // 是否保密 U_Secrecy
    @TableField("U_Secrecy")
    private String uSecrecy;
    // 库存成本价 U_Price
    @TableField("U_Price")
    private BigDecimal uPrice;
    // 最近一次销售报价 LastSalePrice
    @TableField("LastSalePrice")
    private BigDecimal lastSalePrice;
    // 最近一次销售报价时间 LastSaleDate
    @TableField("LastSaleDate")
    private Date lastSaleDate;
    // 最近一次采购报价 LastPurchasePrice
    @TableField("LastPurchasePrice")
    private BigDecimal lastPurchasePrice;
    // 最近一次采购报价时间 LastPurchaseDate
    @TableField("LastPurchaseDate")
    private Date lastPurchaseDate;
    // unit_price 云汉价
    @TableField("unit_price")
    private BigDecimal unitPrice;
    // unit_price_date 云汉价时间
    @TableField("unit_price_date")
    private Date unitPriceDate;
    // cg_avg7 采购avg7
    @TableField("cg_avg7")
    private BigDecimal cgAvg7;
    // cg_avg7 采购avg14
    @TableField("cg_avg14")
    private BigDecimal cgAvg14;
    // cg_avg7 采购avg30
    @TableField("cg_avg30")
    private BigDecimal cgAvg30;
    // xs_avg7 销售avg7
    @TableField("xs_avg7")
    private BigDecimal xsAvg7;
    // xs_avg14 销售avg14
    @TableField("xs_avg14")
    private BigDecimal xsAvg14;
    // xs_avg30 销售avg30
    @TableField("xs_avg30")
    private BigDecimal xsAvg30;
    // StockDays 库存天数
    @TableField("StockDays")
    private String stockDays;
    // LastPricingTime 最近一次定价时间
    @TableField(exist = false)
    private Date lastPricingTime;
    // 最近一次定价 LastPrice
    @TableField(exist = false)
    private BigDecimal lastPrice;
    // 是否人工修改 Modify
    @TableField("Modify")
    private String modify;
    // kc_price7 库存定价(7天)
    @TableField("kc_price7")
    private BigDecimal kcPrice7;
    // reference7 参考价格(7天)
    @TableField("reference7")
    private String reference7;
    // kc_price7 库存定价(14天)
    @TableField("kc_price14")
    private BigDecimal kcPrice14;
    // reference7 参考价格(14天)
    @TableField("reference14")
    private String reference14;
    // kc_price7 库存定价(30天)
    @TableField("kc_price30")
    private BigDecimal kcPrice30;
    // reference7 参考价格(30天)
    @TableField("reference30")
    private String reference30;
    // kc_price 库存定价
    @TableField("kc_price")
    private BigDecimal kcPrice;
    // reference7 参考价格
    @TableField("reference")
    private String reference;
    // kc_price_final 最终库存定价
    @TableField("kc_price_final")
    private BigDecimal kcPriceFinal;
    // reference_final 最终参考价格
    @TableField("reference_final")
    private String referenceFinal;
    // price_2w 2w内单价
    @TableField("price_2w")
    private BigDecimal price2w;
    // quan_2w 2w内单价区间
    @TableField("quan_2w")
    private String quan2w;
    // price_2w_5w 2w-5w单价
    @TableField("price_2w_5w")
    private BigDecimal price2w5w;
    // quan_2w_5w 2w-5w单价区间
    @TableField("quan_2w_5w")
    private String quan2w5w;
    // price_5w_10w 5w_10w单价
    @TableField("price_5w_10w")
    private BigDecimal price5w10w;
    // quan_5w_10w 5w_10w单价区间
    @TableField("quan_5w_10w")
    private String quan5w10w;
    // price_10w 10w+单价
    @TableField("price_10w")
    private BigDecimal price10w;
    // quan_10w 10w+单价区间
    @TableField("quan_10w")
    private String quan10w;
}
