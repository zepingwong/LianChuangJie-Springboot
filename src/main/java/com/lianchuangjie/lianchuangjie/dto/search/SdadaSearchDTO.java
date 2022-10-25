package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SdadaSearchDTO {
    @JsonProperty("sno")
    private String sno;
    @JsonProperty("QuoBrand")
    private String quoBrand;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("page")
    private Integer page;
}
