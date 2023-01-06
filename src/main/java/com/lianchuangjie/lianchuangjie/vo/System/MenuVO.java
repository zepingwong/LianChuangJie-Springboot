package com.lianchuangjie.lianchuangjie.vo.System;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuVO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("Parent")
    private Long parent;
    @JsonProperty("Name")
    private String name;

}
