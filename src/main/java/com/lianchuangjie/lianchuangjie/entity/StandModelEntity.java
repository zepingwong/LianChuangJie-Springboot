package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 根据品牌判断型号是否需要标准化
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OBRA")
public class StandModelEntity {
    @TableField("IsStand")
    private String isStand;
    @TableField("Name")
    private String name;
}
