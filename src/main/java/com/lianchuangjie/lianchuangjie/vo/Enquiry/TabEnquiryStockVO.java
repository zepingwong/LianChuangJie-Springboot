package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabEnquiryStockVO {
    /**
     * @description 仓库代码 WhsCode
     * @resource T_OBTQ.WhsCode
     */
    @JsonProperty("WhsCode")
    private String whsCode;
    /**
     * @description 库存性质编号
     * @resource T_OBTN.U_AreaType
     */
    @JsonProperty("U_AreaType")
    private Long uAreaType;
    /**
     * @description 入库日期 InDate
     * @resource T_OBTN.InDate
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("InDate")
    private Date inDate;
    /**
     * @description 型号 ItemName
     * @resource T_OBTN.ItemName
     */
    @JsonProperty("ItemName")
    private String itemName;
    /**
     * @description U_ECCN
     * @resource T_OBTN.U_ECCN
     */
    @JsonProperty("U_ECCN")
    private String uEccn;
    /**
     * @description 品牌
     * @resource SDADA.QuoBrand
     */
    @JsonProperty("QuoBrand")
    private String quoBrand;
    /**
     * @description 批次 U_Batch
     * @resource T_OBTN.U_Batch
     */
    @JsonProperty("U_Batch")
    private String uBatch;
    /**
     * @description 库存数量 Quantity
     * @resource T_OBTQ.Quantity
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    /**
     * @description 锁货数量 U_LockQty
     * @resource T_OBTN.U_LockQty
     */
    @JsonProperty("U_LockQty")
    private BigDecimal uLockQty;
    /**
     * @description 可用数量
     */
    @JsonProperty("AvailableQty")
    private BigDecimal availableQty;

    public BigDecimal getAvailableQty() {
        if (uLockQty != null) {
            return quantity.subtract(uLockQty);
        }
        return null;
    }

    /**
     * @description 备注 U_Remark
     * @resource T_OBTN.U_Remark
     */
    @JsonProperty("U_Remark")
    private String uRemark;
    /**
     * @description MSL湿度等级 U_msl
     * @resource T_OBTN.U_msl
     */
    @JsonProperty("U_msl")
    private String uMsl;
    /**
     * @description 产地 U_COO
     * @resource T_OBTN.U_COO
     */
    @JsonProperty("U_COO")
    private String uCoo;
    /**
     * @description 实物MPQ U_MPQ
     * @resource T_OBTN.U_MPQ
     */
    @JsonProperty("U_MPQ")
    private BigDecimal uMpq;
    /**
     * @description 采购员名称 U_BuyerName
     * @resource T_OBTN.U_BuyerName
     */
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    /**
     * @description 包装 U_Package
     * @resource T_OBTN.U_Package
     */
    @JsonProperty("U_Package")
    private String uPackage;
    /**
     * @description 原标 U_OriginalBid
     * @resource T_OBTN.U_OriginalBid
     */
    @JsonProperty("U_OriginalBid")
    private String uOriginalBid;
    /**
     * @description 保密库存标记 U_Secrecy
     */
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    /**
     * @description 磨码类型代码 U_GrindingCode
     */
    @JsonProperty("U_GrindingCode")
    private String uGrindingCode;
    /**
     * @description 最低报价
     */
    @JsonProperty("MinPrice")
    private BigDecimal minPrice;

    public BigDecimal getMinPrice() {
        return BigDecimal.valueOf(1);
    }

    /**
     * @description 推荐报价
     */
    @JsonProperty("RecoPrice")
    private BigDecimal recoPrice;

    public BigDecimal getRecoPrice() {
        return BigDecimal.valueOf(1);
    }

    /**
     * @description 入库天数
     */
    @JsonProperty("InDays")
    private Long inDays;

    public Long getInDays() {
        if (inDate != null) {
            Date date = new Date();
            long offset = date.getTime() - inDate.getTime() - 28800000L; // 要剪掉 8 小时时区差值
            return Math.round(offset / 86400000.0);
        }
        return null;
    }
}
