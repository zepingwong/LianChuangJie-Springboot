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
    @TableId(value = "DocEntry", type = IdType.AUTO)
    private Long docEntry;
    @TableField(value = "TriggerName")
    private String triggerName;
    @TableField(value = "TriggerType")
    String triggerType;
    @TableField(value = "StartTime")
    Date startTime;
    @TableField(value = "EndTime")
    Date endTime;
    @TableField(value = "Result")
    Integer result;
}
