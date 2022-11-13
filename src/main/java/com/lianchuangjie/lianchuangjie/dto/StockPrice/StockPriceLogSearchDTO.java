package com.lianchuangjie.lianchuangjie.dto.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceLogSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
    // 开始时间
    private Date timeStart;
    // 结束时间
    private Date timeEnd;
    // 事件类型
    private String triggerName;
    private List<String> triggerNameList;
    public List<String> getTriggerNameList() {
        return Arrays.asList(triggerName.split(","));
    }
    // 触发方式
    private String triggerType;
    private List<String> triggerTypeList;
    public List<String> getTriggerTypeList() {
        return Arrays.asList(triggerType.split(","));
    }
}
