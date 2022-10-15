package com.lianchuangjie.lianchuangjie.entity.Clientele;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO, value = "KeyCode")
    private Integer keyCode;
    // 地区名称
    @TableField(value = "DoMain")
    private String doMain;
    // 一级地区代码
    @TableField(value = "ParentCode")
    private Integer parentCode;
    // 简称-只有一级地区有简称
    @TableField(value = "ShortName")
    private String shortName;
}
