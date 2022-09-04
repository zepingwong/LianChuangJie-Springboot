package com.lianchuangjie.lianchuangjie.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 库存定价查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
    // 型号
    private String modle;
    // 品牌
    private String brand;
    // 库存类型
    private String typeCode;
    // 处理情况
    // 库存天数
    private Integer stockDays;
    // 需要补价
    private Boolean needReplenish;
    // 定价类型
    private Integer pricingType;
}
