package com.lianchuangjie.lianchuangjie.entity.Stock;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 库存批次表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OBTN")
public class StockBatchEntity {
    /**
     * @description 批次ID-主键 AbsEntry
     */
    @TableField(value = "AbsEntry")
    private Long absEntry;
    /**
     * @description 物料编号 ItemCode
     */
    @TableField(value = "ItemCode")
    private String itemCode;
    /**
     * @description 系统内部编号 SysNumber
     */
    @TableField(value = "SysNumber")
    private Long sysNumber;
    /**
     * @description 标签编码 DistNumber
     */
    @TableField(value = "DistNumber")
    private String distNumber;
    /**
     * @description 入库日期 InDate
     */
    @TableField(value = "InDate")
    private Date inDate;
    /**
     * @description 创建日期 CreateDate
     */
    @TableField(value = "CreateDate")
    private Date createDate;
    /**
     * @description 创建用户编号 UserSign
     */
    @TableField(value = "UserSign")
    private Long userSign;
    /**
     * @description 型号 ItemName
     */
    @TableField(value = "ItemName")
    private String itemName;
    /**
     * @description 库存性质编号
     */
    @TableField(value = "U_AreaType")
    private Long uAreaType;
    /**
     * @description 来源单据编号 U_BaseEntry
     */
    @TableField(value = "U_BaseEntry")
    private Long uBaseEntry;
    /**
     * @description 来源单据行号 U_BaseEntry
     */
    @TableField(value = "U_BaseLine")
    private Long uBaseLine;
    /**
     * @description U_ECCN
     */
    @TableField(value = "U_ECCN")
    private String uEccn;
    /**
     * @description 来源单据类型（如采购入库、其他收货等）  U_BaseType
     */
    @TableField(value = "U_BaseType")
    private Long uBaseType;
    /**
     * @description 批次 U_Batch
     */
    @TableField(value = "U_Batch")
    private String uBatch;
    /**
     * @description 品牌类型 U_ProductType
     */
    @TableField(value = "U_ProductType")
    private String uProductType;
    /**
     * @description 包装复核时间 U_BZDateT
     */
    @TableField(value = "U_BZDateT")
    private Date uBzDateT;
    /**
     * @description 包装复核人编号 U_BZUserSign
     */
    @TableField(value = "U_BZUserSign")
    private Long uBzUserSign;
    /**
     * @description 产地 U_COO
     */
    @TableField(value = "U_COO")
    private String uCoo;
    /**
     * @description 锁货数量 U_LockQty
     */
    @TableField(value = "U_LockQty")
    private BigDecimal uLockQty;
    /**
     * @description MSL湿度等级 U_msl
     */
    @TableField(value = "U_msl")
    private String uMsl;
    /**
     * @description 采购员名称 U_BuyerName
     */
    @TableField(value = "U_BuyerName")
    private String uBuyerName;
    /**
     * @description 销售员名称 U_SaleName
     */
    @TableField(value = "U_SaleName")
    private String uSaleName;
    /**
     * @description 保密库存标记 U_Secrecy
     */
    @TableField(value = "U_Secrecy")
    private String uSecrecy;
    /**
     * @description 实物MPQ U_MPQ
     */
    @TableField(value = "U_MPQ")
    private BigDecimal uMpq;
    /**
     * @description 标准MPQ U_MOQ
     */
    @TableField(value = "U_MOQ")
    private BigDecimal uMoq;
    /**
     * @description 采购员编号 U_IsBuyer
     */
    @TableField(value = "U_IsBuyer")
    private Long uIsBuyer;
    /**
     * @description 销售员编号 U_IsSale
     */
    @TableField(value = "U_IsSale")
    private Long uIsSale;
    /**
     * @description 包装 U_Package
     */
    @TableField(value = "U_Package")
    private String uPackage;
    /**
     * @description 备注 U_Remark
     */
    @TableField(value = "U_Remark")
    private String uRemark;
    /**
     * @description U_OriginalBid
     */
    @TableField(value = "U_OriginalBid")
    private String uOriginalBid;
    /**
     * @description 是否磨码标记 U_Grinding
     */
    @TableField(value = "U_Grinding")
    private String uGrinding;
    /**
     * @description 磨码类型代码 U_GrindingCode
     */
    @TableField(value = "U_GrindingCode")
    private String uGrindingCode;
    /**
     * @description 库存数量 Quantity
     */
    @TableField(exist = false)
    private String quantity;
}
