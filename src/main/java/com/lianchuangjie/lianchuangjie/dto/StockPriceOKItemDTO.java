package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockPriceOKItemDTO {
    // 品牌 Brand
    @NotBlank(message = "品牌不能为空")
    @JsonProperty("Brand")
    private String brand;
    // 型号 ItemName
    @NotBlank(message = "型号不能为空")
    @JsonProperty("ItemName")
    private String itemName;
}
