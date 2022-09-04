package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabStockPriceBaseVO {
    @JsonProperty("packing")
    private String packing;
    @JsonProperty("package")
    private String packages;
    @JsonProperty("spq")
    private String spq;
    @JsonProperty("datasheet")
    private String datasheet;
    @JsonProperty("msl_new")
    private String mslNew;
    // 最近一次销售报价
    @JsonProperty("LastSalePrice")
    private Float lastSalePrice;
    // 最难一次销售报价时间
    @JsonProperty("LastSaleDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSaleDate;
    // 最近一次采购报价
    @JsonProperty("LastPurchasePrice")
    private Float lastPurchasePrice;
    // 最难一次采购报价时间
    @JsonProperty("LastPurchaseDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastPurchaseDate;
    // 云汉价
    @JsonProperty("unit_price")
    private Float unitPrice;
    // 云汉价时间
    @JsonProperty("unit_price_date")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date unitPriceDate;
    // 采购avg7
    @JsonProperty("cg_avg7")
    private Float cgAvg7;
    // 采购avg14
    @JsonProperty("cg_avg14")
    private Float cgAvg14;
    // 采购avg30
    @JsonProperty("cg_avg30")
    private Float cgAvg30;
    // 销售avg7
    @JsonProperty("xs_avg7")
    private Float xsAvg7;
    // 销售avg14
    @JsonProperty("xs_avg14")
    private Float xsAvg14;
    // 销售avg30
    @JsonProperty("xs_avg30")
    private Float xsAvg30;
    // 库存定价(14天)
    @JsonProperty("kc_price14")
    private Float kcPrice14;
    // 参考价格(14天)
    @JsonProperty("reference14")
    private String reference14;
    // 库存定价(30天)
    @JsonProperty("kc_price30")
    private Float kcPrice30;
    // 参考价格(30天)
    @JsonProperty("reference30")
    private String reference30;
}
