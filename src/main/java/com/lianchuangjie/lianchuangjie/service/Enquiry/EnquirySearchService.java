package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySearchResultVO;

public interface EnquirySearchService {
    Page<EnquirySearchResultVO> list(EnquirySearchDTO enquirySearchDTO);
}
