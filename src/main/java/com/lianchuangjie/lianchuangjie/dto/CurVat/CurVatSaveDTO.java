package com.lianchuangjie.lianchuangjie.dto.CurVat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurVatSaveDTO {
    @NotBlank(message = "税率代码不能为空")
    @JsonProperty("VatGroup")
    private String vatGroup;
    @NotBlank(message = "货币类型不能为空")
    @JsonProperty("Currency")
    private String currency;
}
