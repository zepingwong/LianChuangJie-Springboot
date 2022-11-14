package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description 字典
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomHeadDictVO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("Key")
    private String key;
}
