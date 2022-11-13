package com.lianchuangjie.lianchuangjie.vo.StockRank;

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
public class StockRankVO {
    // 最终排名
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 品牌
    @JsonProperty("Brand")
    private String brand;
    // 型号
    @JsonProperty("Modle")
    private String modle;
    /**
     * 01.询价频次
     */
    // 加权询价频次排名
    @JsonProperty("InquiryFrequencyRank")
    private Long inquiryFrequencyRank;
    // 近一年加权询价频次
    @JsonProperty("InquiryFrequency")
    private BigDecimal inquiryFrequency;
    // 询价频次得分
    @JsonProperty("InquiryFrequencyScore")
    private BigDecimal inquiryFrequencyScore;
    @JsonProperty("InquiryFrequencyFirst")
    private Integer inquiryFrequencyFirst;
    @JsonProperty("InquiryFrequencySecond")
    private Integer inquiryFrequencySecond;
    @JsonProperty("InquiryFrequencyThird")
    private Integer inquiryFrequencyThird;
    @JsonProperty("InquiryFrequencyForth")
    private Integer inquiryFrequencyForth;
    /**
     * 02.询价客户数
     */
    // 加权询价客户数排名
    @JsonProperty("InquiryCustomersRank")
    private Long inquiryCustomersRank;
    // 近一年加权询价客户数
    @JsonProperty("InquiryCustomers")
    private BigDecimal inquiryCustomers;
    // 加权询价客户数得分
    @JsonProperty("InquiryCustomersScore")
    private BigDecimal inquiryCustomersScore;
    @JsonProperty("InquiryCustomersFirst")
    private Integer inquiryCustomersFirst;
    @JsonProperty("InquiryCustomersSecond")
    private Integer inquiryCustomersSecond;
    @JsonProperty("InquiryCustomersThird")
    private Integer inquiryCustomersThird;
    @JsonProperty("InquiryCustomersForth")
    private Integer inquiryCustomersForth;
    /**
     * 03.订单客户数量
     */
    // 加权订单客户数量排名
    @JsonProperty("OrderCustomersRank")
    private Long orderCustomersRank;
    // 近一年加权订单客户数量
    @JsonProperty("OrderCustomers")
    private BigDecimal orderCustomers;
    // 加权订单客户数量得分
    @JsonProperty("OrderCustomersScore")
    private BigDecimal orderCustomersScore;
    @JsonProperty("OrderCustomersFirst")
    private Integer orderCustomersFirst;
    @JsonProperty("OrderCustomersSecond")
    private Integer orderCustomersSecond;
    @JsonProperty("OrderCustomersThird")
    private Integer orderCustomersThird;
    @JsonProperty("OrderCustomersForth")
    private Integer OrderCustomersForth;
    /**
     * 04.交货单频次
     */
    // 近一年加权交货单频次排名
    @JsonProperty("DeliveryFrequencyRank")
    private Long deliveryFrequencyRank;
    // 近一年加权交货单频次
    @JsonProperty("DeliveryFrequency")
    private BigDecimal deliveryFrequency;
    // 加权交货单频次得分
    @JsonProperty("DeliveryFrequencyScore")
    private BigDecimal deliveryFrequencyScore;
    @JsonProperty("DeliveryFrequencyFirst")
    private Integer deliveryFrequencyFirst;
    @JsonProperty("DeliveryFrequencySecond")
    private Integer deliveryFrequencySecond;
    @JsonProperty("DeliveryFrequencyThird")
    private Integer deliveryFrequencyThird;
    @JsonProperty("DeliveryFrequencyForth")
    private Integer deliveryFrequencyForth;
    /**
     * 05.销售总数
     */
    // 近一年加权销售总数排名
    @JsonProperty("DeliveryQuantityRank")
    private Long deliveryQuantityRank;
    // 近一年加权销售总数
    @JsonProperty("DeliveryQuantity")
    private BigDecimal deliveryQuantity;
    // 加权销售总数得分
    @JsonProperty("DeliveryQuantityScore")
    private BigDecimal deliveryQuantityScore;
    @JsonProperty("DeliveryQuantityFirst")
    private Integer deliveryQuantityFirst;
    @JsonProperty("DeliveryQuantitySecond")
    private Integer deliveryQuantitySecond;
    @JsonProperty("DeliveryQuantityThird")
    private Integer deliveryQuantityThird;
    @JsonProperty("DeliveryQuantityForth")
    private Integer deliveryQuantityForth;
    /**
     * 06.利润率
     */
    // 近一年平均利润率排名
    @JsonProperty("AverageProfitRank")
    private Long averageProfitRank;
    // 近一年平均利润率
    @JsonProperty("AverageProfit")
    private BigDecimal averageProfit;
    // 近一年平均利润率得分
    @JsonProperty("AverageProfitScore")
    private BigDecimal averageProfitScore;
    /**
     * 07.采购价格
     */
    // 近一年采购价格排名
    @JsonProperty("AveragePPriceAFVATRank")
    private Long averagePPriceAFVATRank;
    // 近一年平均采购价格
    @JsonProperty("AveragePPriceAFVAT")
    private BigDecimal averagePPriceAFVAT;
    @JsonProperty("AveragePPriceAFVATScore")
    private BigDecimal averagePPriceAFVATScore;
    /**
     * 08.采购数量
     */
    // 近一年采购数量排名
    @JsonProperty("SumPurchaseQuantityRank")
    private Long sumPurchaseQuantityRank;
    // 近一年采购数量
    @JsonProperty("SumPurchaseQuantity")
    private Integer sumPurchaseQuantity;
    // 采购数量排名得分
    @JsonProperty("SumPurchaseQuantityScore")
    private BigDecimal sumPurchaseQuantityScore;
    /**
     * 09.采购总频次
     */
    // 近一年采购总频次排名
    @JsonProperty("PurchaseFrequencyRank")
    private Long purchaseFrequencyRank;
    // 近一年采购总频次
    @JsonProperty("PurchaseFrequency")
    private Integer purchaseFrequency;
    // 采购总频次得分
    @JsonProperty("PurchaseFrequencyScore")
    private BigDecimal purchaseFrequencyScore;
    /**
     * 10.销售总额
     */
    // 近一年销售总额排名
    @JsonProperty("SumSaleMoneyRank")
    private Long sumSaleMoneyRank;
    // 近一年销售总额
    @JsonProperty("SumSaleMoney")
    private BigDecimal sumSaleMoney;
    // 销售总额得分
    @JsonProperty("SumSaleMoneyScore")
    private BigDecimal sumSaleMoneyScore;
    /**
     * 11.采购总额
     */
    // 近一年采购总额排名
    @JsonProperty("SumPurchaseMoneyRank")
    private Long sumPurchaseMoneyRank;
    // 近一年采购总额
    @JsonProperty("SumPurchaseMoney")
    private BigDecimal sumPurchaseMoney;
    // 采购总额得分
    @JsonProperty("SumPurchaseMoneyScore")
    private BigDecimal sumPurchaseMoneyScore;
    /**
     * 12.品牌得分
     */
    // 品牌得分排名
    @JsonProperty("BrandScoreRank")
    private Long brandScoreRank;
    // 品牌得分
    @JsonProperty("BrandScore")
    private BigDecimal brandScore;
    /**
     * 总分
     */
    @JsonProperty("ToTalScore")
    private BigDecimal toTalScore;
}
