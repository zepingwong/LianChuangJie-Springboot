package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 库存清单子表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OBSL1")
public class StockListSubEntity {
    /**
     * @description 编号-主键
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description 文件内部行号-主键 LineNum
     */
    @TableField(value = "LineNum")
    @JsonProperty("LineNum")
    private Long lineNum;
}
