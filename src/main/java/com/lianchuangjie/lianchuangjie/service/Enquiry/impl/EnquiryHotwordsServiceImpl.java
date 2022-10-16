package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.mapper.EnquiryHotwordsMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryHotwordsService;
import com.lianchuangjie.lianchuangjie.vo.EnquiryHotwordsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquiryHotwordsServiceImpl implements EnquiryHotwordsService {
    @Resource
    EnquiryHotwordsMapper enquiryHotwordsMapper;
    @Override
    public List<EnquiryHotwordsVO> getList() {
        return enquiryHotwordsMapper.selectList();
    }
}
