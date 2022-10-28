package com.lianchuangjie.lianchuangjie.dto.StockPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description 库存定价一键OK
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockPriceOKAllDTO {
    // 当前日期 DocDate
    @NotNull(message = "库存定价日期不能为空")
    @JsonProperty("DocDate")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd 00:00:00")
    private Date docDate;
    @JsonProperty("Items")
    private List<StockPriceOKDTO> items;
}
