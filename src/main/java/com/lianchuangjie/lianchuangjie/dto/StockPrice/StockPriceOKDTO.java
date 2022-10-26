package com.lianchuangjie.lianchuangjie.dto.StockPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 库存定价OK
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockPriceOKDTO {
    // 当前日期 DocDate
    @NotNull(message = "库存定价日期不能为空")
    @JsonProperty("DocDate")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd 00:00:00")
    private Date docDate;
    // 品牌 Brand
    @JsonProperty("Brand")
    private String brand;
    // 型号 ItemName
    @NotBlank(message = "型号不能为空")
    @JsonProperty("ItemName")
    private String itemName;
    @JsonProperty("Batch")
    private String batch;
    // price_2w 2w内单价
    @JsonProperty("price_2w")
    private BigDecimal price2w;
    // price_2w_5w 2w-5w单价
    @JsonProperty("price_2w_5w")
    private BigDecimal price2w5w;
    // price_5w_10w 5w_10w单价
    @JsonProperty("price_5w_10w")
    private BigDecimal price5w10w;
    // price_10w 10w+单价
    @JsonProperty("price_10w")
    private BigDecimal price10w;
    // 最终定价
    @JsonProperty("kc_price_final")
    private BigDecimal kcPriceFinal;
    // 确认日期
    @JsonProperty("ConfirmDate")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd 00:00:00")
    private Date confirmDate;
    @JsonProperty("Modify")
    private String modify;
}
