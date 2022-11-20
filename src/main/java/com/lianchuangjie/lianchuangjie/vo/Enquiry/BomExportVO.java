package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @description BOM单标准化结果导出
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomExportVO {
    /**
     * @description 序号 LineNum
     * @resource U_ICIN1.LineNum
     */
    private Long lineNum;
    /**
     * @description 需求型号 Modle
     */
    private String modle;
    /**
     * @description 匹配型号
     */
    private String standModle;
    /**
     * @description 需求品牌
     */
    private String brand;
    /**
     * @description 匹配品牌 StandBrand
     */
    private String standBrand;
    /**
     * @description 需求数量 demandQty
     */
    private BigDecimal demandQty;
    /**
     * @description 客户备注 CurRemark
     */
    private String curRemark;
}
