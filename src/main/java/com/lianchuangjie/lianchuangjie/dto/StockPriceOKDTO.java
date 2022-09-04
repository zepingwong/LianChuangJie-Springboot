package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description 库存定价OK
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockPriceOKDTO {
    // 当前日期 DocDate
    @NotNull(message = "库存定价日期不能为空")
    @JsonProperty("DocDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date docDate;
    // 品牌 Brand
    @NotBlank(message = "品牌不能为空")
    @JsonProperty("Brand")
    private String brand;
    // 型号 ItemName
    @NotBlank(message = "型号不能为空")
    @JsonProperty("ItemName")
    private String itemName;
    // kc_price 库存定价
    @JsonProperty("kc_price")
    private Float kcPrice;
    // reference7 参考价格
    @JsonProperty("reference")
    private String reference;
    // kc_price_final 最终库存定价
    @JsonProperty("kc_price_final")
    private Float kcPrice_final;
    // reference_final 最终参考价格
    @JsonProperty("reference_final")
    private String referenceFinal;
    // price_2w 2w内单价
    @JsonProperty("price_2w")
    private Float price2w;
    // price_2w_5w 2w-5w单价
    @JsonProperty("price_2w_5w")
    private Float price2w5w;
    // price_5w_10w 5w_10w单价
    @JsonProperty("price_5w_10w")
    private Float price5w10w;
    // price_10w 10w+单价
    @JsonProperty("price_10w")
    private Float price10w;
    // 最终定价
    @JsonProperty("kc_price_final")
    private Float kcPriceFinal;
}
