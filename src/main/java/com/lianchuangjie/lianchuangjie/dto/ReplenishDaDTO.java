package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplenishDaDTO {
    @JsonProperty("Batch")
    private String uQuoYear;
    @JsonProperty("Brand")
    private String uQuoBrand;
    @JsonProperty("ItemName")
    private String uQuoModle;
}
