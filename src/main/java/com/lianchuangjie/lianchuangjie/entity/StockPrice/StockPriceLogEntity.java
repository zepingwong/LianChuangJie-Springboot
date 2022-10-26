package com.lianchuangjie.lianchuangjie.entity.StockPrice;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 库存定价算法日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_SPAL")
public class StockPriceLogEntity {
    @TableField(value = "TriggerType")
    String triggerType;
    @TableField(value = "StartTime")
    Date startTime;
    @TableField(value = "EndTime")
    Date endTime;
    @TableField(value = "Result")
    Integer result;
}
