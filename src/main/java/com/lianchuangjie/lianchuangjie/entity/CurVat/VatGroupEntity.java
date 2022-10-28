package com.lianchuangjie.lianchuangjie.entity.CurVat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OVTG")
public class VatGroupEntity {
    // 税率代码
    @TableId(value = "Code")
    private String code;
    // 名称
    @TableField(value = "Name")
    private String name;
    @TableField(value = "Type")
    // 类型
    private String type;
    // 税率
    @TableField(value = "Rate")
    private BigDecimal rate;
}
