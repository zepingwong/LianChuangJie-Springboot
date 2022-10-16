package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
    // 供方单价报价价格,人民币不含税 T_ICIN1.U_QuoPrice
    @JsonProperty("U_QuoPrice")
    private BigDecimal uQuoPrice;
    // 供应商等级 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
}
