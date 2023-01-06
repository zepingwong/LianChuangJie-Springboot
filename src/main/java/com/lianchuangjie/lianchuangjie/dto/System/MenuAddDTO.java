package com.lianchuangjie.lianchuangjie.dto.System;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuAddDTO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("Parent")
    private Long parent;
    @JsonProperty("Path")
    private String path;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Page")
    private String page;
    @JsonProperty("Icon")
    private String icon;
    @JsonProperty("Title")
    private String title;
}
