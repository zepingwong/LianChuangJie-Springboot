package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description BOM单解析匹配结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomQueryResVO {
    /**
     * @description BOM单匹配结果列表
     */
    @JsonProperty("BomQueryItemList")
    List<BomQueryItemVO> bomQueryItemList;
    /**
     * @description BOM单匹配结果总行数
     */
    @JsonProperty("TotalSize")
    Integer totalSize;
    /**
     * @description 需求数量
     */
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
}
