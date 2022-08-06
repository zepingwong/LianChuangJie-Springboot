package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.entity.EnquiryEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper;
import com.lianchuangjie.lianchuangjie.service.EnquiryService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryServiceImpl implements EnquiryService {
    @Resource
    EnquiryMapper enquiryMapper;
    @Override
    public EnquiryMainVO getEnquiryMainService(Long docEntry) {
        ResponseEnum.ISNULL.assertIsFalse(enquiryMapper.existByDocEntry(docEntry), "编号为" +docEntry+"的询价单不存在");
        Long userSign = SessionUtil.getUserSign();
        EnquiryEntity enquiryEntity = enquiryMapper.selectByDocEntry(docEntry, userSign);
        ResponseEnum.HAS_NO_AUTHENTICATION.assertNotNull(enquiryEntity, "您没有权限查看编号为"+ docEntry +"的询价单");
        EnquiryMainVO enquiryMain = new EnquiryMainVO();
        BeanUtils.copyProperties(enquiryEntity, enquiryMain);
        return enquiryMain;
    }
}
