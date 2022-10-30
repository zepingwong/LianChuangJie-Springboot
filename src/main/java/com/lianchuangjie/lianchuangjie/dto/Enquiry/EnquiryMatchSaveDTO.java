package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.dto.BomQueryMainDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySubDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryMatchSaveDTO {
    @Valid
    @JsonProperty("EnquiryMatchHead")
    EnquiryMatchHeadDTO enquiryMatchHead;
    @Valid
    @JsonProperty("EnquiryMatchItemList")
    List<EnquiryMatchItemDTO> enquiryMatchItemList;
}
