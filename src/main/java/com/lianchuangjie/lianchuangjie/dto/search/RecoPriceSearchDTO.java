package com.lianchuangjie.lianchuangjie.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecoPriceSearchDTO {
    // 型号
    private String modle;
    // 品牌
    private String brand;
}
