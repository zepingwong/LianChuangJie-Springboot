package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryAvailableSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryAvailableVO;

public interface EnquiryAvailableService {
    Page<TabEnquiryAvailableVO> list(EnquiryAvailableSearchDTO tabSearchDTO);
}
