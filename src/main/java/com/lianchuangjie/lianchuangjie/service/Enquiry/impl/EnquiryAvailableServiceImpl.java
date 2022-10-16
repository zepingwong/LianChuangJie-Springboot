package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryAvailableMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryAvailableService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryAvailableVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class EnquiryAvailableServiceImpl implements EnquiryAvailableService {
    @Resource
    EnquiryAvailableMapper enquiryAvailableMapper;
    @Override
    public Page<TabEnquiryAvailableVO> list(TabSearchDTO searchCondition) {
        Page<TabEnquiryAvailableVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquiryAvailableMapper.selectList(page, searchCondition);
        return page;
    }
}
