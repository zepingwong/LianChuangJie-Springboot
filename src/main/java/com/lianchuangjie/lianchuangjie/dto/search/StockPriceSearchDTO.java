package com.lianchuangjie.lianchuangjie.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceSearchDTO {
    /**
     * @description 页码
     * @defaultValue 1
     */
    private Integer page;
    /**
     * @description 每页显示数量
     * @defaultValue 10
     * @maxValue 50
     */
    private Integer size;
}
