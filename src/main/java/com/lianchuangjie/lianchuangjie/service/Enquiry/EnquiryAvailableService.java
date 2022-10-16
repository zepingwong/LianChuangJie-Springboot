package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryAvailableSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryAvailableVO;

public interface EnquiryAvailableService {
    Page<TabEnquiryAvailableVO> list(EnquiryAvailableSearchDTO tabSearchDTO);
}
