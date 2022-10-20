package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquirySearchMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySearchService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySearchResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquirySearchServiceImpl implements EnquirySearchService {
    @Resource
    EnquirySearchMapper enquirySearchMapper;
    @Override
    public Page<EnquirySearchResultVO> list(EnquirySearchDTO searchCondition) {
        Page<EnquirySearchResultVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquirySearchMapper.selectList(page, searchCondition);
        return page;
    }
}
