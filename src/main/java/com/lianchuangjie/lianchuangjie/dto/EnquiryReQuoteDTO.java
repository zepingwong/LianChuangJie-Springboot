package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryReQuoteDTO {
    // 询价单编号
    @NotBlank(message = "询价单编号不能为空")
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 询价单内部行号
    @NotBlank(message = "询价单行号不能为空")
    @JsonProperty("LineNum")
    private Long LineNum;
    // 报价单编号
    @NotBlank(message = "货源编号不能为空")
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单行号
    @NotBlank(message = "货源行号不能为空")
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 采购员编号
    @NotBlank(message = "采购员编号不能为空")
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 报价品牌
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    // 报价型号
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
}
