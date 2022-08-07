package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class EnquirySubServiceImpl implements EnquirySubService {
    @Resource
    EnquirySubMapper enquirySubMapper;
    @Override
    public List<EnquirySubVO> getListService(Long docEntry) {
        Long userSign = SessionUtil.getUserSign();
        List<EnquirySubEntity> list = enquirySubMapper.searchAllByDocEntry(docEntry, userSign);
        List<EnquirySubVO> res = new ArrayList<>();
        for (EnquirySubEntity enquirySubEntity:list) {
            EnquirySubVO enquirySubVO = new EnquirySubVO();
            BeanUtils.copyProperties(enquirySubEntity, enquirySubVO);
            res.add(enquirySubVO);
        }
        return res;
    }
}
