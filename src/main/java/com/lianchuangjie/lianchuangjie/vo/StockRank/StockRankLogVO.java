package com.lianchuangjie.lianchuangjie.vo.StockRank;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class StockRankLogVO {
    @JsonProperty("DocEntry")
    Long docEntry;
    @JsonProperty("TriggerName")
    private String triggerName;
    @JsonProperty("TriggerType")
    String triggerType;
    @JsonProperty("StartTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Date startTime;
    @JsonProperty("EndTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Date endTime;
    @JsonProperty("Result")
    Integer result;
}
