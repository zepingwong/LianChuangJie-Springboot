package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_BOM1")
public class BomSubEntity {
    // 文件编号-主键 DocEntry
    private Long DocEntry;
    // 文件内部行号-主键 LineNum
    private Long LineNum;
    // 型号 Modle
    private String Modle;
    // 品牌 Brand
    private String Brand;
    // 需求数量 DemandQty
    private BigDecimal DemandQty;
    // 客户备注 CurRemark
    private String CurRemark;
}
