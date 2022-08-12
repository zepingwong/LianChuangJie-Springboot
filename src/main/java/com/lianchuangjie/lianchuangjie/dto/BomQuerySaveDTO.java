package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BomQuerySaveDTO {
    @JsonProperty("BomQueryConsInfo")
    BomQueryConsInfoDTO bomQueryConsInfo;
    @JsonProperty("BomQueryItemList")
    List<BomQueryItemDTO> bomQueryItemList;
}
