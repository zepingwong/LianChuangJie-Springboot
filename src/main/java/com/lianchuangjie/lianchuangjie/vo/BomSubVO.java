package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomSubVO {
    // 文件编号-主键 DocEntry
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 文件内部行号-主键 LineNum
    @JsonProperty("LineNum")
    private Long LineNum;
    // 型号 Modle
    @JsonProperty("Modle")
    private String Modle;
    // 品牌 Brand
    @JsonProperty("Brand")
    private String Brand;
    // 需求数量 DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal DemandQty;
    // 客户备注 CurRemark
    @JsonProperty("CurRemark")
    private String CurRemark;
}
