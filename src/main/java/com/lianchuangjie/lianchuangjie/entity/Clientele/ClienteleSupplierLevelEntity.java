package com.lianchuangjie.lianchuangjie.entity.Clientele;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 供应商等级代码表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OGHZ")
public class ClienteleSupplierLevelEntity {
    // 等级代码
    private Integer Code;
    // 等级
    private String Level;
}
