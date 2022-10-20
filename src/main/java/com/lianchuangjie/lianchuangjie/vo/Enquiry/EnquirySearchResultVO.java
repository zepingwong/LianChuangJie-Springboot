package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 搜索结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquirySearchResultVO {
    // 型号
    @JsonProperty("ItemName")
    private String itemName;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // MSL
    @JsonProperty("U_msl")
    private String uMsl;
    // 标准MPQ
    @JsonProperty("U_MOQ")
    private String umoq;
    // ECCN
    @JsonProperty("U_ECCN")
    private String ueccn;
    // U_LockQty 锁货数量
    @JsonProperty("U_LockQty")
    private BigDecimal uLockQty;
    // 库存数量
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 可用数量
    @JsonProperty("AvailableQty")
    private BigDecimal availableQty;
    // 批次
    @JsonProperty("U_Batch")
    private String uBatch;
    // 区间定价
    @JsonProperty("price_2w")
    private BigDecimal price2w;
    @JsonProperty("price_2w_5w")
    private BigDecimal price_2w_5w;
    @JsonProperty("price_5w_10w")
    private BigDecimal price_5w_10w;
    @JsonProperty("price_10w")
    private BigDecimal price_10w;
    // StockDays 库存天数
    @JsonProperty("StockDays")
    private Integer stockDays;
    // InDate 入库时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("InDate")
    private Date inDate;
    // 产地
    @JsonProperty("U_COO")
    private String ucoo;
    // 包装
    @JsonProperty("U_Package")
    private String uPackage;
    // 采购员
    @JsonProperty("U_BuyerName")
    private String uBuyerName;
    // 库存性质
    @JsonProperty("U_AreaType")
    private String uAreaType;
    // 原标
    @JsonProperty("U_OriginalBid")
    private String uOriginalBid;
    // 仓库代码
    @JsonProperty("WhsCode")
    private String whsCode;
    // 建议售价
    @JsonProperty("U_ThinkPrice")
    private BigDecimal uThinkPrice;
    // U_GrindingCode 磨码类型
    @JsonProperty("U_GrindingCode")
    private String uGrindingCode;
    // 是否保密
    @JsonProperty("U_Secrecy")
    private String uSecrecy;
}
