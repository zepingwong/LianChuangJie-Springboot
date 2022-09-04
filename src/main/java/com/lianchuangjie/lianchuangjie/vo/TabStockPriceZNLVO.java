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
public class TabStockPriceZNLVO {
    // 型号
    @JsonProperty("ItemName")
    private String itemName;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 价值排名
    @JsonProperty("Series")
    private Integer series;
    // 搜索次数（30天内）
    @JsonProperty("SEOQty")
    private BigDecimal SEOQty;
    // 搜索公司（30天内）
    @JsonProperty("SEOCompany")
    private BigDecimal SEOCompany;
    // 云价格条数（30天内）
    @JsonProperty("PriceQty")
    private BigDecimal priceQty;
    // 云价格记录（30天内）
    @JsonProperty("PriceCompany")
    private BigDecimal priceCompany;
    // 现货家数
    @JsonProperty("OnHandQty")
    private BigDecimal onHandQty;
    // 现货库存
    @JsonProperty("OnHand")
    private BigDecimal onHand;
    // 日期
    @JsonProperty("CreateDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
