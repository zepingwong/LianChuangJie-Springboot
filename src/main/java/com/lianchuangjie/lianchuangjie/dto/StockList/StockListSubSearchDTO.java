package com.lianchuangjie.lianchuangjie.dto.StockList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
