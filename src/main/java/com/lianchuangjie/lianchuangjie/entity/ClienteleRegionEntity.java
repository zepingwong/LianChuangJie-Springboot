package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 业务合作伙伴地区代码表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OADD")
public class ClienteleRegionEntity {
    // 地区代码
    private Integer KeyCode;
    // 地区名称
    private String DoMain;
    // 一级地区代码
    private Integer ParentCode;
    // 简称-只有一级地区有简称
    private String ShortName;
}
