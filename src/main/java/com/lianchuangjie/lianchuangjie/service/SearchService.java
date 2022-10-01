package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.vo.SearchQueryVO;

public interface SearchService {
    Page<SearchQueryVO> list(EnquirySearchDTO enquirySearchDTO);
}
