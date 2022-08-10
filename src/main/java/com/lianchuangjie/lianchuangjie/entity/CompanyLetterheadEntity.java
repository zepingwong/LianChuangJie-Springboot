package com.lianchuangjie.lianchuangjie.entity;

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
@TableName("U_OGHZ")
public class CompanyLetterheadEntity {
    // 公司编号
    private Long DocEntry;
    // 公司代码
    private String ComCode;
    // 公司名称
    private String Company;
}
