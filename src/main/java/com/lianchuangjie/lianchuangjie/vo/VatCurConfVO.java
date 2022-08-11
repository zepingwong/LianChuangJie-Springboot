package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VatCurConfVO {
    /**
     * @description 序号
     */
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 货币
     */
    @JsonProperty("Currency")
    private String currency;
    /**
     * @description 税率代码
     */
    @JsonProperty("VatGroup")
    private String vatGroup;
    /**
     * @description 下拉列表 value
     */
    @JsonProperty("Value")
    private String value;
    /**
     * @description 下拉列表 value
     */
    @JsonProperty("Label")
    private String label;
    /**
     * @description 税点
     */
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    /**
     * @description 类型-I代表进项，O代表销项
     */
    @JsonProperty("Type")
    private String type;
}
