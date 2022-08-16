package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CompanyDepartmentVO {
    /**
     * @description 部门编号
     */
    @JsonProperty("DeptCode")
    private String deptCode;
    /**
     * @description 部门名称
     */
    @JsonProperty("DeptName")
    private String name;
}
