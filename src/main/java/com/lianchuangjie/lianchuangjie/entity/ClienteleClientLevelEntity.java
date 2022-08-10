package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 客户等级代码表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OHDJ")
public class ClienteleClientLevelEntity {
    // 等级代码
    private Integer Code;
    // 等级
    private String Level;
}
