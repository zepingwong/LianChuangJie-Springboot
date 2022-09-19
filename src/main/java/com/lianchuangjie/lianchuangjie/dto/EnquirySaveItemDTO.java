package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquirySaveItemDTO {
    @JsonProperty("LineNum")
    private Long lineNum;
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("recommend")
    private List<EnquirySubItemDTO> recommend;
}
