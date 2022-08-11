package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description 常用交易货币及税率配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_VCCG")
public class VatCurConfEntity {
    /**
     * @description 序号
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description 货币
     */
    @TableField(value = "Currency")
    private String currency;
    /**
     * @description 税率代码
     */
    @TableField(value = "VatGroup")
    private String vatGroup;
    /**
     * @description 税率文本
     */
    @TableField(exist = false)
    private String vatName;
    /**
     * @description 添加时间
     */
    @TableField(value = "CreateTime")
    private Date createTime = new Date();
    /**
     * @description 更新时间
     */
    @TableField(value = "UpdateTime")
    private Date updateTime;
}
