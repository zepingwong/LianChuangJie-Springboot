package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquirySaveItemDTO {
    // 询价单行号
    @JsonProperty("LineNum")
    private Long lineNum;
    // 询价单编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 货源单据编号
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 货源行号
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 询价单单据编号
    @JsonProperty("ItemEntry")
    private Long itemEntry;
    // 询价单行号
    @JsonProperty("ItemLine")
    private Long itemLine;
    // 报价数量
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty;
    // 报价价格
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 供应商名称
    @JsonProperty("U_CardName")
    private String uCardName;
    // 供应商代码
    @JsonProperty("U_CardCode")
    private String uCardCode;
    // 供应商等级
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 供应商性质
    @JsonProperty("U_QuoGroupCode")
    private String uQuoGroupCode;
    // 采购员编号
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 采购员姓名
    @JsonProperty("BuyerName")
    private String buyerName;
}
