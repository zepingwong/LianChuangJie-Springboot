package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 库存清单主表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OBSL")
public class StockListMainEntity {
    /**
     * @description 编号-主键
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
}
