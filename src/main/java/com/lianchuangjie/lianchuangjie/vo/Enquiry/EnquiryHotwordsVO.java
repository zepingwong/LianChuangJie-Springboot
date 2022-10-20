package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 询价热词
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryHotwordsVO {
    /**
     * @description 查询次数
     */
    @JsonProperty("Count")
    private Long count;
    /**
     * @description 型号
     */
    @JsonProperty("Modle")
    private String modle;
}
