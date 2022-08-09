package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquirySubItemDTO {
    // 询价单编号
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 询价单内部行号
    @JsonProperty("LineNum")
    private Long LineNum;
    // 询价状态
}
