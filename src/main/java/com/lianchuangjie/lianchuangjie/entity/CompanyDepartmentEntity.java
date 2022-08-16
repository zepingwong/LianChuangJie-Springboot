package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公司部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OCDP")
public class CompanyDepartmentEntity {
    /**
     * @description 部门编号
     */
    @TableField(value = "DeptCode")
    private String deptCode;
    /**
     * @description 部门名称
     */
    @TableField(value = "Name")
    private String name;
}
