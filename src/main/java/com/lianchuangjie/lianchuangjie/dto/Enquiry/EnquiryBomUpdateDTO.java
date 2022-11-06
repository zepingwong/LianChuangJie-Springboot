package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新BOM单一行
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryBomUpdateDTO {
    @JsonProperty("Modle")
    private String modle;
    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("LineNum")
    private Long lineNum;
}
