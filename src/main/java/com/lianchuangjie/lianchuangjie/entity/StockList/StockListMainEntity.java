package com.lianchuangjie.lianchuangjie.entity.StockList;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description 库存清单主表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_StockList")
public class StockListMainEntity {
    /**
     * @description 编号-主键
     */
    @TableId(value = "DocEntry")
    private Long docEntry;
    // 文件名
    @TableField(value = "FileName")
    private String fileName;
    // 发送时间
    @TableField(value = "CreateDate")
    private Date createDate;
    // 供应商名称
    @TableField(value = "CardName")
    private String cardName;
    // 供应商代码
    @TableField(value = "CardCode")
    private String cardCode;
    // 状态
    @TableField(value = "Status")
    private String status;
    // 供应商等级
    @TableField(value = "Level")
    private String level;
    // 供应商性质
    @TableField(value = "GroupName")
    private String groupName;
}
