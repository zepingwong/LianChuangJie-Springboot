package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomUploadResVO {
    // BOM单编号
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // BOM单标题
    @JsonProperty("TitleList")
    private List<String> TitleList;
    // BOM单数据项
    @JsonProperty("BomItemList")
    private List<Map<String, String>> BomItemList;
    // BOM单子表
    @JsonProperty("BomSubList")
    private List<BomSubVO> BomSubList;
}
