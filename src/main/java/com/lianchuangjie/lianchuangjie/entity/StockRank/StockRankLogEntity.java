package com.lianchuangjie.lianchuangjie.entity.StockRank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_SRAL")
public class StockRankLogEntity {
    // 编号
    @TableId(value = "DocEntry", type = IdType.AUTO)
    private Long docEntry;
    // 事件名称
    @TableField(value = "TriggerName")
    private String triggerName = "库存排名";
    // 触发方式 手动触发/定时任务
    @TableField(value = "TriggerType")
    private String triggerType;
    // 开始事件
    @TableField(value = "StartTime")
    private Date startTime = new Date();
    // 结束事件
    @TableField(value = "EndTime")
    private Date endTime;
    // 运行结果 1 成功 0 失败
    @TableField(value = "Result")
    private Integer result;
    // 算法运行时间
    @TableField(value = "RunTime")
    private Long runTime;
    public Long getRunTime() {
        if (startTime != null & endTime != null) {
            return  (endTime.getTime() -startTime.getTime())/ 1000;
        }
        return 0L;
    }
}
