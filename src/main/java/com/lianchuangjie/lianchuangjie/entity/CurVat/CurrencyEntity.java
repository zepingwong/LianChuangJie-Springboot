package com.lianchuangjie.lianchuangjie.entity.CurVat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 货币类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OCRN")
public class CurrencyEntity {
    /**
     * @description 货币类型代码
     */
    @JsonProperty("Code")
    @TableField(value = "Code")
    private String code;
    /**
     * @description 货币类型名称
     */
    @JsonProperty("Name")
    @TableField(value = "Name")
    private String name;
}
