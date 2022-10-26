package com.lianchuangjie.lianchuangjie.vo.StockPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockPriceLogVO {
    @JsonProperty("DocEntry")
    Long docEntry;
    @JsonProperty("TriggerType")
    String triggerType;
    @JsonProperty("StartTime")
    Date startTime;
    @JsonProperty("EndTime")
    Date endTime;
    @JsonProperty("Result")
    Integer result;
}
