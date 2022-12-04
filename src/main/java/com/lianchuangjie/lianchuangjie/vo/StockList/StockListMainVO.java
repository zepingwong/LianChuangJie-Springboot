package com.lianchuangjie.lianchuangjie.vo.StockList;

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
public class StockListMainVO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 供应商名称
    @JsonProperty("CardName")
    private String cardName;
    // 供应商类型
    @JsonProperty("GroupName")
    private String groupName;
    // 供应商等级
    @JsonProperty("Level")
    private String level;
    // 发送时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CreateDate")
    private Date createDate;
    // 处理情况
    @JsonProperty("Status")
    private String status;
    // 建议数量
    @JsonProperty("SuggestionQty")
    private BigDecimal suggestionQty;
    // 现有库存数量
    @JsonProperty("SQuantity")
    private BigDecimal SQuantity;
    // 近两周询价次数
    @JsonProperty("EnquiryCount")
    private BigDecimal enquiryCount;
    // 交易货币
    @JsonProperty("CurRate")
    private String curRate;
}
