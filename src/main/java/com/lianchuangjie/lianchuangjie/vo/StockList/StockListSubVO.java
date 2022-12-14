package com.lianchuangjie.lianchuangjie.vo.StockList;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockListSubVO {
    // 文档编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 行号
    @JsonProperty("LineNum")
    private Long lineNum;
    // 型号
    @JsonProperty("Modle")
    private String modle;
    // 匹配型号
    @JsonProperty("sno")
    private String sno;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 数量
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 价格
    @JsonProperty("Price")
    private BigDecimal price;
    // 批次
    @JsonProperty("Year")
    private String year;
    // 状态
    @JsonProperty("Status")
    private String status;
    // kc_price_final 最近一次库存定价
    @JsonProperty("kc_price_final")
    private BigDecimal kcPriceFinal;
    // 最近一次采购价
    @JsonProperty("U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;
    // 现有库存数量
    @JsonProperty("StockQuantity")
    private BigDecimal stockQuantity;
    // 建议补货数量
    @JsonProperty("SuggestionQty")
    private BigDecimal suggestionQty;
    // 在途库存数量
    @JsonProperty("OpenQty")
    private BigDecimal openQty;
    // 库存排名
    @JsonProperty("StockRank")
    private Long stockRank;
    // 正能量近30天搜索次数
    @JsonProperty("SEOQty")
    private BigDecimal SEOQty;
    // 备注
    @JsonProperty("Remark")
    private String remark;
}
