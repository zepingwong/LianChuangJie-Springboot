package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.mapper.SearchQueryMapper;
import com.lianchuangjie.lianchuangjie.service.EnquirySearchService;
import com.lianchuangjie.lianchuangjie.vo.SearchQueryVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquirySearchServiceImpl implements EnquirySearchService {
    @Resource
    SearchQueryMapper searchQueryMapper;
    @Override
    public Page<SearchQueryVO> list(EnquirySearchDTO searchCondition) {
        Page<SearchQueryVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        searchQueryMapper.selectList(page, searchCondition);
        return page;
    }
}
