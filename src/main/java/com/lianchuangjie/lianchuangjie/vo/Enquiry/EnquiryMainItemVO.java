package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 询价单主表信息-单行
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryMainItemVO {
    // 询价单位 T_ICIN.CardName
    @JsonProperty("CardName")
    private String cardName;
    // 询价单编号 T_ICIN.DocEntry
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 报价单完成行数 EnquireComplete
    @JsonProperty("EnquireComplete")
    private Integer enquireComplete;
    // 报价单总行数 EnquireSum
    @JsonProperty("EnquireSum")
    private Long enquireSum;
    // 处理情况 T_ICIN.State
    @JsonProperty("State")
    private Integer state;
    // 推荐报价更新 T_ICIN.New
    @JsonProperty("New")
    private String New;
    // 采购回复 PurchaseReply T_ICIN1 对应 DocEntry Status 为 Y 的条数
    @JsonProperty("PurchaseReply")
    private Long purchaseReply;
    // 询价来源 _ICIN.SourceType
    @JsonProperty("U_SourceType")
    private String uSourceType;
    // 失效时间上限 InvalidDateMax
    @JsonProperty("InvalidDateMax")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateMax;
    // 失效时间下限 InvalidDateMin
    @JsonProperty("InvalidDateMin")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateMin;
    // 发送时间 CreateDate
    @JsonProperty("CreateDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
