package com.lianchuangjie.lianchuangjie.dto.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceLogSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
}
