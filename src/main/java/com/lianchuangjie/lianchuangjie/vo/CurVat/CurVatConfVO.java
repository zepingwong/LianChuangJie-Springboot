package com.lianchuangjie.lianchuangjie.vo.CurVat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurVatConfVO {
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
    // 添加时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CreateTime")
    private Date createTime;
    // 修改时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("UpdateTime")
    private Date updateTime;
}
