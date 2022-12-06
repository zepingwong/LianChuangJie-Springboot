package com.lianchuangjie.lianchuangjie.dto.StockList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockListSubSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
    // 库存清单编号
    private Long docEntry;
    // 型号
    private String modle;
    // 品牌
    private String brand;
    // 库存排名
    private Long stockRank;
    // 供应商报价
    private BigDecimal price;
    // 处理情况
    private String status;
    // 在途库存
    private String openQty;
    // 建议补货数量
    private String suggestionQty;
    // 热门料
    private String popularModle;
}
