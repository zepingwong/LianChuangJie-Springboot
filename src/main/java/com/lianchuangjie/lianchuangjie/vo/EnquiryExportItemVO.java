package com.lianchuangjie.lianchuangjie.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryExportItemVO {
    /**
     * @description 序号 LineNum
     * @resource U_ICIN1.LineNum
     */
    private Long lineNum;
    /**
     * @description 报价型号 QuoModle
     * @resource U_ICIN1.QuoModle
     */
    private String quoModle;
    /**
     * @description 客户料号
     */
    private String itemCode;
    /**
     * @description 报价品牌
     */
    private String quoBrand;
    /**
     * @description 报价批次 SuoYear
     */
    private String suoYear;
    /**
     * @description 报价数量 SuoQuantity
     */
    private BigDecimal suoQuantity;
    /**
     * @description 销售报价单价 PriceAfVAT
     */
    private BigDecimal priceAfVAT;
    /**
     * @description 报价交期 SuoDelivery
     */
    private String suoDelivery;
    /**
     * @description 销售备注 LineRemark
     */
    private String lineRemark;
}
