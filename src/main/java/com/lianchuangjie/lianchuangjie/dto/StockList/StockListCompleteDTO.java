package com.lianchuangjie.lianchuangjie.dto.StockList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockListCompleteDTO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("LineNum")
    private Long lineNum;
}
