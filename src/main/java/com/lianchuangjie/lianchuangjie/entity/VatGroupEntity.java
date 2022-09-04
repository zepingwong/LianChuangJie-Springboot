package com.lianchuangjie.lianchuangjie.entity;

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
    private String Code;
    // 名称
    private String Name;
    // 类型
    private String Type;
    // 税率
    private BigDecimal Rate;
}
