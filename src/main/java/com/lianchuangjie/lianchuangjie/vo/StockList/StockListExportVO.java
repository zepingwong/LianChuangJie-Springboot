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
public class StockListExportVO {
    // 行号
    private Long lineNum;
    // 型号
    private String modle;
    // 匹配型号
    private String sno;
    // 品牌
    private String brand;
    // 数量
    private BigDecimal quantity;
    // 价格
    private BigDecimal price;
    // 批次
    private String year;
    // 状态
    private String status;
    // kc_price_final 最近一次库存定价
    private BigDecimal kcPriceFinal;
    // 最近一次采购价
    private BigDecimal uPriceAfVAT;
    // 现有库存数量
    private BigDecimal stockQuantity;
    // 建议补货数量
    private BigDecimal suggestionQty;
    // 在途库存数量
    private BigDecimal openQty;
    // 库存排名
    private Long stockRank;
    // 正能量近30天搜索次数
    private BigDecimal SEOQty;
    // 备注
    private String remark;
}
