package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 采购订单子表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OPOR1")
public class PurchaseOrderSubEntity {
    /**
     * @description 单据编号-主键
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description 单据行号-主键
     */
    @TableField(value = "LineNum")
    private Long lineNum;
    /**
     * @description 行状态-O表示未完成、C表示已完成、Q表示已取消
     */
    @TableField(value = "LineStatus")
    private String lineStatus;
    /**
     * @description 物料编号 ItemCode
     */
    @TableField(value = "ItemCode")
    private String itemCode;
    /**
     * @description 型号 Dscription
     */
    @TableField(value = "Dscription")
    private String dscription;
    /**
     * 仓库代码 WhsCode
     */
    @TableField(value = "WhsCode")
    private String whsCode;
    /**
     * @description 订单数量 Quantity
     */
    @TableField(value = "Quantity")
    private BigDecimal quantity;
    /**
     * @description 未清数量 OpenQty
     */
    @TableField(value = "OpenQty")
    private BigDecimal openQty;

    /**
     * @description 预计交期 ShipDate
     */
    @TableField(value = "ShipDate")
    private Date shipDate;
    /**
     * @description 要求批次 U_Batch
     */
    @TableField(value = "U_Batch")
    private String uBatch;
    /**
     * @description 品牌 U_Brand
     */
    @TableField(value = "U_Brand")
    private String uBrand;
    /**
     * @description U_Remark 备注
     */
    @TableField(value = "U_Remark")
    private String uRemark;
    /**
     * @description U_ECCN
     */
    @TableField(value = "U_ECCN")
    private String uEccn;
    /**
     * @description 含税单价 U_PriceAfVAT
     */
    @TableField(value = "U_PriceAfVAT")
    private BigDecimal uPriceAfVAT;
    /**
     * @description 税率代码 U_VatGroup
     */
    @TableField(value = "U_VatGroup")
    private String uVatGroup;
}
