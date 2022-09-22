package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquiryIsOrderedService;
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
        EnquirySubEntity enquirySubEntity = enquirySubMapper.getOne(queryWrapper);
        if (enquirySubEntity != null) {
            enquirySubEntity.setIsOrdered("Y");
            return enquirySubMapper.order(enquirySubEntity);
        } else {
            return false;
        }
    }
}
