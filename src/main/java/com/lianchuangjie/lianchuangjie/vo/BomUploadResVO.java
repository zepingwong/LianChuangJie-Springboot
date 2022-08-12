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
    private Long docEntry;
    // BOM单标题列表
    @JsonProperty("TitleList")
    private List<String> titleList;
    // BOM单数据项列表
    @JsonProperty("BomItemList")
    private List<Map<String, String>> bomItemList;
}
