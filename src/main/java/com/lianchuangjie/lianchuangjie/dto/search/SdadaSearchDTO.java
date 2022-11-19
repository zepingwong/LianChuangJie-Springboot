package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SdadaSearchDTO {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("sno")
    private String sno;
    @JsonProperty("QuoBrand")
    private String quoBrand;
    @JsonProperty("FrgnName")
    private String frgnName;
    @JsonProperty("IsTagged")
    private String isTagged;
}
