package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.dto.BomQueryConsInfoDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.service.BomQuerySaveService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BomQuerySaveServiceImpl implements BomQuerySaveService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Override
    public Boolean save(BomQuerySaveDTO bomQuerySaveDTO) {
        BomQueryConsInfoDTO bomQueryConsInfo = bomQuerySaveDTO.getBomQueryConsInfo();
        EnquiryMainEntity enquiryMainEntity = new EnquiryMainEntity();
        BeanUtils.copyProperties(bomQueryConsInfo, enquiryMainEntity);
        System.out.println(enquiryMainEntity);
        return null;
    }
}
