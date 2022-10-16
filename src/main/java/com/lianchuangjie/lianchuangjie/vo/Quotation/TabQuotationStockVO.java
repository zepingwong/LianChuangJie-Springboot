package com.lianchuangjie.lianchuangjie.vo.Quotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购报价库存信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabQuotationStockVO {
    // 仓库代码 WhsCode
    @JsonProperty("WhsCode")
    private String whsCode;
    // 库存性质编号
    @JsonProperty("U_AreaType")
    private Long uAreaType;
    // 入库日期 InDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("InDate")
    private Date inDate;
    // 型号 ItemName
    @JsonProperty("ItemName")
    private String itemName;
    // 批次 U_Batch
    @JsonProperty("U_Batch")
    private String uBatch;
    // U_ECCN
    @JsonProperty("U_ECCN")
    private String uEccn;
    // 库存数量 Quantity
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 锁货数量 U_LockQty
    @JsonProperty("U_LockQty")
    private BigDecimal uLockQty;
    // 可用数量
    @JsonProperty("AvailableQty")
    private BigDecimal availableQty;
    // 备注 U_Remark
    @JsonProperty("U_Remark")
    private String uRemark;
    // 品牌
    @JsonProperty("QuoBrand")
    private String quoBrand;
    // MSL湿度等级 U_msl
    @JsonProperty("U_msl")
    private String uMsl;
    // 产地 U_COO
    @JsonProperty("U_COO")
    private String uCoo;
    // 实物MPQ U_MPQ
    @JsonProperty("U_MPQ")
    private BigDecimal uMpq;
    // 采购员名称 U_BuyerName
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    // 包装 U_Package
    @JsonProperty("U_Package")
    private String uPackage;
    // 原标 U_OriginalBid
    @JsonProperty("U_OriginalBid")
    private String uOriginalBid;
    // 保密库存标记 U_Secrecy
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
    // 磨码类型代码 U_GrindingCode
    @JsonProperty("U_GrindingCode")
    private String uGrindingCode;
    // 最低报价
    @JsonProperty("MinPrice")
    private BigDecimal minPrice;

    public BigDecimal getMinPrice() {
        return BigDecimal.valueOf(1);
    }
    // 建议收件
    @JsonProperty("RecoPrice")
    private BigDecimal recoPrice;

    public BigDecimal getRecoPrice() {
        return BigDecimal.valueOf(1);
    }

    // 入库天数
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
