package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryIsOrderedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryIsOrderedServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquiryIsOrderedService {
    @Resource
    EnquirySubMapper enquirySubMapper;

    @Override
    public Boolean handle(EnquiryIsOrderedDTO enquiryIsOrderedDTO) {
        QueryWrapper<EnquirySubEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DocEntry", enquiryIsOrderedDTO.getDocEntry());
        queryWrapper.eq("LineNum", enquiryIsOrderedDTO.getLineNum());
        queryWrapper.eq("BaseEntry", enquiryIsOrderedDTO.getBaseEntry());
        queryWrapper.eq("BaseLine", enquiryIsOrderedDTO.getBaseLine());
        EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(queryWrapper);
        if (enquirySubEntity != null) {
            enquirySubEntity.setIsOrdered("Y");
            int res = enquirySubMapper.update(enquirySubEntity, queryWrapper);
            return res > 1;
        } else {
            return false;
        }
    }
}
