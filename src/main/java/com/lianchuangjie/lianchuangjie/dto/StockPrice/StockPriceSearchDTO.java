package com.lianchuangjie.lianchuangjie.dto.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String modify;
    // 库存天数
    private Integer stockDays;
    // 需要补价
    private Boolean needReplenish;
    // 定价类型
    private Integer pricingType;
    // 今日需定价
    private Boolean needToday = true;
    // 今日新入库
    private String newToday;
    // 成单日期
    private Date orderDate;
    // 用户编号
    private Integer userSign;
}
