package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotationReplyDTO {
    /**
     * @description 询价单编号
     * @target U_ICIN1.DocEntry
     */
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 询价单内部编号-行号
     * @target U_ICIN1.LineNum
     */
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 采购报价次数，采购报价单行号
     * @target T_ICIN1.LineNum
     */
    @JsonProperty("BaseLine")
    private Long baseLine;
    @JsonProperty("OwnerCode")
    private Long ownerCode;
}
