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
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单行号
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 销售报价价格
    @NotBlank(message = "销售报价不能为空")
    @JsonProperty("PriceAfVAT")
    private BigDecimal priceAfVAT;
    // 销售报价数量
    @NotBlank(message = "报价数量不能为空")
    @JsonProperty("U_QuoQty")
    private BigDecimal suoQuantity;
    // 采购员编号
    @JsonProperty("U_Buyer")
    private Long suoBuyer;
    // 报价品牌
    @JsonProperty("U_QuoBrand")
    private String quoBrand;
    // 报价型号
    @JsonProperty("U_QuoModle")
    private String quoModle;
    // 采购报价货币
    @JsonProperty("U_QuoCurr")
    private String quoCurr;
    // 采购报价税率代码
    @JsonProperty("U_QuoVatGroup")
    private String quoVatGroup;
    // 报价批次
    @JsonProperty("U_QuoYear")
    private String suoYear;
    // 报价交期
    @JsonProperty("U_QuoDelivery")
    private String suoDelivery;
    // 是否是备用货源
    @JsonProperty("IsSpare")
    private String isSpare;
    // 是否已下单
    @JsonProperty("IsOrdered")
    private String isOrdered;
}
