package com.lianchuangjie.lianchuangjie.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询有效货源
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryAvailableSearchDTO {
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
    // 需求型号 Modle
    private String modle;
    // 单据编号
    private Long docEntry;
}
