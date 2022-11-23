package com.lianchuangjie.lianchuangjie.dto.StockRank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 库存定价查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRankSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
    // 型号
    private String modle;
    // 品牌
    private String brand;
    // 在途库存数量 0-在途库存数为0 1-在途库存数不为0 2-所有值
    private Integer openQty;
    // 建议补货数量 0-建议补货数为0 1-建议补货数不为0 2-所有值
    private Integer suggestionQty;
}
