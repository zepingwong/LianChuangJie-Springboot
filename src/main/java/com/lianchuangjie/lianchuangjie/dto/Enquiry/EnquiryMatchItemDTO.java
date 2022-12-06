package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquiryMatchItemDTO {
    /**
     * @description 序号-关联型号序号相同
     */
    @JsonProperty("ItemId")
    private Long itemId;
    /**
     * @description 需求型号
     */
    @JsonProperty("sno")
    private String modle;
    /**
     * @description 品牌
     */
    @JsonProperty("Brand")
    private String brand;
    /**
     * @description 参考价格
     */
    @JsonProperty("PrePrice")
    private BigDecimal prePrice;
    /**
     * @description 询价状态代码
     */
    @JsonProperty("Status")
    private String status;
    /**
     * @description 处理方式
     */
    @JsonProperty("ItemDescStatus")
    private String itemDescStatus;
    /**
     * @description 客户备注 CurRemark
     */
    @JsonProperty("CurRemark")
    private String curRemark;
    /**
     * @description 匹配情况
     */
    @JsonProperty("Match")
    private String match;
    /**
     * @description 失效时间
     */
    @JsonProperty("ExpDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接参数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expDate;
    /**
     * @description 重要程度
     */
    @JsonProperty("KeyPoint")
    private String keyPoint;
    @JsonProperty("KeyRemark")
    private String keyRemark;
    /**
     * @description ECCN
     */
    @JsonProperty("ECCN")
    private String eccn;
    //
    @JsonProperty("Currency")
    private String currency;
    // 需求数量 U_ICIN1.DemandQty
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    // Delivery 需求交期
    @JsonProperty("Delivery")
    private String delivery;
    // Year 需求批次
    @JsonProperty("Year")
    private String year;
    // 税点
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    // 是否保密标记 Secrecy
    @JsonProperty("Secrecy")
    private String secrecy;
    // 需求封装
    @JsonProperty("Package")
    private String packages;
    // 报价状态，默认为 0
    private Integer state = 0;
    // 是否确认报价
    private String checkIN = "0";
    // 选中的采购
    @JsonProperty("Buyer")
    private String buyer;
    public String getBuyer() {
        return buyer != null ? buyer : "";
    }
    @JsonProperty("VatName")
    private String vatName;
    // 品名
    @JsonProperty("ItemFrgnName")
    private String itemFrgnName;
    // 包装
    @JsonProperty("Packaging")
    private String packaging;
    // 紧急
    @JsonProperty("UrgentType")
    private String urgentType;
    // 税率代码
    @JsonProperty("VatGroup")
    private String vatGroup;
    // 直接定价价格
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
}
