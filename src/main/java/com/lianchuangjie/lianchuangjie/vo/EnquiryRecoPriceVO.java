package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryRecoPriceVO {
    // 引用采购报价的采购员姓名 T_OUSI.UserName
    @JsonProperty("SuoBuyerName")
    private String suoBuyerName;
    // 采购部门名称/货源 T_OCDP.Name
    @JsonProperty("U_DftDeptName")
    private String uDftDeptName;
}
