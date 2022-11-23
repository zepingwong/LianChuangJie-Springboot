package com.lianchuangjie.lianchuangjie.vo.StockRank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 库存排名日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StockRankLogVO {
    // 编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 事件名称
    @JsonProperty("TriggerName")
    private String triggerName;
    // 触发方式
    @JsonProperty("TriggerType")
    private String triggerType;
    // 开始时间
    @JsonProperty("StartTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    // 结束时间
    @JsonProperty("EndTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    // 执行结果
    @JsonProperty("Result")
    private Integer result;
    // 运行时间
    @JsonProperty("RunTime")
    private Long runTime;
}
