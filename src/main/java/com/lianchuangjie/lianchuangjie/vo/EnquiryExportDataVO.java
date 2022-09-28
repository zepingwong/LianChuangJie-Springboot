package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.annotation.Resource;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryExportDataVO {
    @JsonProperty("HeadData")
    EnquiryExportHeadVO enquiryExportHead;
    @JsonProperty("DataList")
    List<EnquiryExportItemVO> enquiryExportList;
}
