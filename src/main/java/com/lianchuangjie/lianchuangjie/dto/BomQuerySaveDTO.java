package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BomQuerySaveDTO {
    @Valid
    @JsonProperty("BomQueryConsInfo")
    BomQueryConsInfoDTO bomQueryConsInfo;
    @Valid
    @JsonProperty("BomQueryItemList")
    List<BomQueryItemDTO> bomQueryItemList;
}
