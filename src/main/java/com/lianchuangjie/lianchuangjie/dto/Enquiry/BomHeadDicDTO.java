package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BomHeadDicDTO {
    @NotBlank(message = "键不能为空")
    @JsonProperty("DicKey")
    private String dicKey;
    @NotBlank(message = "值不能为空")
    @JsonProperty("Value")
    private String value;
    @JsonProperty("DocEntry")
    private Long docEntry;
}
