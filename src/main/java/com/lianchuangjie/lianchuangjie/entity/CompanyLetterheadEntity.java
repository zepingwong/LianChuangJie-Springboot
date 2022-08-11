package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 公司抬头名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OBPL")
public class CompanyLetterheadEntity {
    // 公司编号
    @TableField(value = "DocEntry")
    private Long docEntry;
    // 公司代码
    @TableField(value = "ComCode")
    private String comCode;
    // 公司名称
    @TableField(value = "Company")
    private String company;
}
