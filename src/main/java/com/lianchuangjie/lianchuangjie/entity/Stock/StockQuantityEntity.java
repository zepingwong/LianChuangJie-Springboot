package com.lianchuangjie.lianchuangjie.entity.Stock;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description 库存仓库数量表 T_OBTQ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OBTQ")
public class StockQuantityEntity {
    /**
     * @description 物料编号 ItemCode
     */
    @TableField(value = "ItemCode")
    private String itemCode;
    /**
     * @description 系统批次编号 SysNumber
     */
    @TableField(value = "SysNumber")
    private Long sysNumber;
    /**
     * @description 仓库代码 WhsCode
     */
    @TableField(value = "WhsCode")
    private String whsCode;
    /**
     * @description 移动加权平均成本 AvgPrice
     */
    @TableField(value = "AvgPrice")
    private BigDecimal avgPrice;
    /**
     * @description 库存数量 Quantity
     */
    @TableField(value = "Quantity")
    private BigDecimal quantity;
    /**
     * @description CommitQty
     */
    @TableField(value = "CommitQty")
    private BigDecimal commitQty;

    @TableField(value = "CountQty")
    private BigDecimal countQty;

    @TableField(value = "AbsEntry")
    private Long absEntry;
    /**
     * @description 批次ID-与T_OBTQ表的AbsEntry进行链接
     */
    @TableField(value = "MdAbsEntry")
    private Long mdAbsEntry;
}
