package com.lianchuangjie.lianchuangjie.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryExportDataVO {
    EnquiryExportHeadVO enquiryExportHead;
    List<EnquiryExportItemVO> enquiryExportList;
}
