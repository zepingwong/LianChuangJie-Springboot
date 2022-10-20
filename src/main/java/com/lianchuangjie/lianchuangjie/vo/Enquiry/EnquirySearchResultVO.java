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
    @JsonProperty("Modle")
    private String sno;
    // 品牌
    @JsonProperty("QuoBrand")
    private String quoBrand;
    // MSL
    @JsonProperty("msl_new")
    private String mslNew;
    // MPQ
    @JsonProperty("spq")
    private String spq;
    // ECCN
    @JsonProperty("ECCN")
    private String eccn;
    // U_LockQty 锁货数量
    @JsonProperty("U_LockQty")
    private BigDecimal uLockQty;
    // 库存数量
    @JsonProperty("Quantity")
    private BigDecimal quantity;
    // 可用数量
    @JsonProperty("AvaQuantity")
    private BigDecimal avaQuantity;
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
}
