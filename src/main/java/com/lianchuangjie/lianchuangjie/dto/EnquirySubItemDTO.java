package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hpsf.Decimal;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquirySubItemDTO {
    // 询价单编号
    @NotBlank(message = "询价单编号不能为空")
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 询价单内部行号
    @NotBlank(message = "询价单行号不能为空")
    @JsonProperty("LineNum")
    private Long LineNum;
    // 报价单编号
    @NotBlank(message = "报价信息编号不能为空")
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单行号
    @NotBlank(message = "报价信息行号不能为空")
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 销售报价价格
    @NotBlank(message = "销售报价不能为空")
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
}
