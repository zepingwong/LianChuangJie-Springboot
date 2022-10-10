package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description 单个型号匹配 DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleQueryDTO {
    // 型号
    @JsonProperty("Modle")
    private String modle;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 需求数量 DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    public BigDecimal getDemandQty() {
        if (demandQty != null) {
            return demandQty;
        }else {
            return BigDecimal.valueOf(0);
        }
    }
    // 销售员
    @JsonProperty("SlpCode")
    private Long slpCode;
    // 销售部门
    @JsonProperty("DeptCode")
    private String deptCode;
    @NotNull(message = "页码不能为空")
    private Integer page;
    // 每页显示数量 最大值为50
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页最多显示50条数据")
    private Integer size;
}
