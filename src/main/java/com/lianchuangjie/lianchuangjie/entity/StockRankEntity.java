package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description 库存排名表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("StockRank")
public class StockRankEntity {
    /**
     * @description 编号-主键
     */
    @TableId(value = "DocEntry")
    private Long docEntry;
    /**
     * @description LineNum 行号
     */
    @TableField(value = "LineNum")
    private Long lineNum;
    /**
     * @description ItemCode 物料编号
     */
    @TableField(value = "ItemCode")
    private String itemCode;
    /**
     * @description Modle 型号
     */
    @TableField(value = "Modle")
    private String modle;
    /**
     * @description Brand 品牌
     */
    @TableField(value = "Brand")
    private String brand;
    /**
     * @description OverallScore 总得分
     */
    @TableField(value = "OverallScore")
    private BigDecimal overallScore;
    /**
     * @description LockQty 在途库存数量
     */
    @TableField(value = "LockQty")
    private BigDecimal lockQty;
    /**
     * @description 现有库存数量（除去在途库存）
     */
    @TableField(value = "StockQty")
    private BigDecimal stockQty;
    /**
     * @description RecoQty 建议补货数量
     */
    @TableField(value = "RecoQty")
    private BigDecimal recoQty;
    /**
     * @description 询价频次
     */
    // 距今1个月
    @TableField(value = "InquiryFrequencyFirst")
    private Integer inquiryFrequencyFirst;
    // 距今2个月
    @TableField(value = "InquiryFrequencySecond")
    private Integer inquiryFrequencySecond;
    // 距今3个月
    @TableField(value = "InquiryFrequencyThird")
    private Integer inquiryFrequencyThird;
    // 距今9-12个月
    @TableField(value = "InquiryFrequencyFourth")
    private Integer inquiryFrequencyFourth;
    // 近1年
    @TableField(value = "InquiryFrequency")
    private Integer inquiryFrequency;
    // 得分
    @TableField(value = "InquiryFrequencyScore")
    private BigDecimal inquiryFrequencyScore;
    // 排名
    @TableField(value = "InquiryFrequencyRank")
    private BigDecimal inquiryFrequencyRank;
    /**
     * @description 询价客户数
     */
    // 距今1个月
    @TableField(value = "InquiryCustomersFirst")
    private Integer inquiryCustomersFirst;
    // 距今2个月
    @TableField(value = "InquiryCustomersSecond")
    private Integer inquiryCustomersSecond;
    // 距今3个月
    @TableField(value = "InquiryCustomersThird")
    private Integer inquiryCustomersThird;
    // 距今9-12个月
    @TableField(value = "InquiryCustomersFourth")
    private Integer inquiryCustomersFourth;
    // 近1年
    @TableField(value = "InquiryCustomers")
    private Integer inquiryCustomers;
    // 得分
    @TableField(value = "InquiryCustomersScore")
    private BigDecimal inquiryCustomersScore;
    // 排名
    @TableField(value = "InquiryCustomersRank")
    private BigDecimal inquiryCustomersRank;
    /**
     * @description 成单客户数
     */
    // 距今1个月
    @TableField(value = "TrgetCustomersFirst")
    private Integer trgetCustomersFirst;
    // 距今2个月
    @TableField(value = "TrgetCustomersSecond")
    private Integer trgetCustomersSecond;
    // 距今3个月
    @TableField(value = "TrgetCustomersThird")
    private Integer trgetCustomersThird;
    // 距今9-12个月
    @TableField(value = "TrgetCustomersFourth")
    private Integer trgetCustomersFourth;
    // 近1年
    @TableField(value = "TrgetCustomers")
    private Integer trgetCustomers;
    // 得分
    @TableField(value = "TrgetCustomersScore")
    private BigDecimal trgetCustomersScore;
    // 排名
    @TableField(value = "TrgetCustomersRank")
    private BigDecimal trgetCustomersRank;
    /**
     * @description 成单次数
     */
    // 距今1个月
    @TableField(value = "TrgetQtyFirst")
    private Integer trgetQtyFirst;
    // 距今2个月
    @TableField(value = "TrgetQtySecond")
    private Integer trgetQtySecond;
    // 距今3个月
    @TableField(value = "TrgetQtyThird")
    private Integer trgetQtyThird;
    // 距今9-12个月
    @TableField(value = "TrgetQtyFourth")
    private Integer trgetQtyFourth;
    // 近1年
    @TableField(value = "TrgetQty")
    private Integer trgetQty;
    // 得分
    @TableField(value = "TrgetQtyScore")
    private BigDecimal trgetQtyScore;
    // 排名
    @TableField(value = "TrgetQtyRank")
    private BigDecimal trgetQtyRank;
    /**
     * @description 销售数量
     */
    // 距今1个月
    @TableField(value = "SaleQtyFirst")
    private Integer saleQtyFirst;
    // 距今2个月
    @TableField(value = "SaleQtySecond")
    private Integer saleQtySecond;
    // 距今3个月
    @TableField(value = "SaleQtyThird")
    private Integer saleQtyThird;
    // 距今9-12个月
    @TableField(value = "SaleQtyFourth")
    private Integer saleQtyFourth;
    // 近1年
    @TableField(value = "SaleQty")
    private Integer saleQty;
    // 得分
    @TableField(value = "SaleQtyScore")
    private BigDecimal saleQtyScore;
    // 排名
    @TableField(value = "SaleQtyRank")
    private BigDecimal saleQtyRank;
    /**
     * @description 利润率
     */
    // 近一年平均
    @TableField(value = "RateAverage")
    private BigDecimal rateAverage;
    // 得分
    @TableField(value = "RateScore")
    private BigDecimal rateScore;
    // 排名
    @TableField(value = "RateRank")
    private BigDecimal rateRank;
    /**
     * @description 采购
     */
    // 近一年平均采购单价（RMB）
    @TableField(value = "QuotePrice")
    private BigDecimal quotePrice;
    // 近一年总采购数量
    @TableField(value = "QuoteQty")
    private Integer quoteQty;
    // 近一年采购频次
    @TableField(value = "QuoteFrequency")
    private Integer quoteFrequency;
    /**
     * @description 销售总额
     */
    @TableField(value = "SaleTotal")
    private BigDecimal saleTotal;
    /**
     *
     * @description 采购总额
     */
    @TableField(value = "QuoteTotal")
    private BigDecimal quoteTotal;
}
