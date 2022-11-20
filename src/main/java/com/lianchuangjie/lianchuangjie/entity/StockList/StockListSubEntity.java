package com.lianchuangjie.lianchuangjie.entity.StockList;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description 库存清单子表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_StockList1")
public class StockListSubEntity {
    /**
     * @description 编号-主键
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description 文件内部行号-主键 LineNum
     */
    @TableField(value = "LineNum")
    @JsonProperty("LineNum")
    private Long lineNum;
    // 型号
    @TableField(value = "Modle")
    private String modle;
    // 品牌
    @TableField(value = "Brand")
    private String brand;
    // 数量
    @TableField(value = "Quantity")
    private BigDecimal quantity;
    // 批次
    @TableField(value = "year")
    private String year;
    // 单价
    @TableField(value = "Price")
    private BigDecimal price;
    // 备注
    @TableField(value = "Remark")
    private String remark;
}
