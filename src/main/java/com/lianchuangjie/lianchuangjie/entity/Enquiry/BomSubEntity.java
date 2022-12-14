package com.lianchuangjie.lianchuangjie.entity.Enquiry;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_BOM11")
public class BomSubEntity {
    // 文件编号-主键 DocEntry
    @TableField(value = "DocEntry")
    private Long docEntry;
    // 文件内部行号-主键 LineNum
    @TableField(value = "LineNum")
    private Long lineNum;
    // 型号 Modle
    @TableField(value = "Modle")
    private String modle;
    // 标准化型号 StandModle
    @TableField(value = "StandModle")
    private String standModle;
    // 品牌 Brand
    @TableField(value = "Brand")
    private String brand;
    // 标准化品牌
    @TableField(value = "StandBrand")
    private String standBrand;
    // 需求数量 DemandQty
    @TableField(value = "DemandQty")
    private BigDecimal demandQty;
    // 客户备注 CurRemark
    @TableField(value = "CurRemark")
    private String curRemark;
    // 状态
    @TableField(value = "Status")
    private String status;
}
