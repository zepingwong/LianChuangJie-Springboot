package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 销售员等级
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_CUR4")
public class SaleLevelEntity {
    // 销售员编号
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    // 销售员等级名称 销售员等级名称
    @TableField(value = "CusLevel")
    private String cusLevel;
    // 销售员等级代码
    @TableField("Level")
    private String level;
}
