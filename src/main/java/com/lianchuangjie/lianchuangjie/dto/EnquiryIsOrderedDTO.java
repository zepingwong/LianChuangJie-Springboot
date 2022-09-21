package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryIsOrderedDTO {
    @NotBlank(message = "询价单编号不能为空")
    @JsonProperty("DocEntry")
    private Long docEntry;
    @NotBlank(message = "询价单编号不能为空")
    @JsonProperty("LineNum")
    private Long lineNum;
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    @JsonProperty("BaseLine")
    private Long baseLine;

}
