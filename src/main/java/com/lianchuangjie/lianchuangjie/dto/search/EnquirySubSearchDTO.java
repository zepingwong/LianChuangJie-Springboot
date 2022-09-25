package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 询价单子表查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquirySubSearchDTO {
    // 询价单编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 销售员编号
    @JsonProperty("OwnerCode")
    private Long ownerCode;
}
