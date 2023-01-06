package com.lianchuangjie.lianchuangjie.entity.System;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_WebMenu")
public class MenuEntity {
    @TableId("DocEntry")
    private Long docEntry;
    @TableField("Path")
    private String path;
    @TableField("Title")
    private String title;
    @TableField("Name")
    private String name;
    @TableField("Page")
    private String page;
    @TableField("Parent")
    private Long parent;
    @TableField("Icon")
    private String icon;
    @TableField("MenuHidden")
    private String menuHidden;
    @TableField("TabHidden")
    private String tabHidden;
}
