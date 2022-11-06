package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomSubMapper;
import com.lianchuangjie.lianchuangjie.service.BomSubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BomSubServiceImpl extends ServiceImpl<BomSubMapper, BomSubEntity> implements BomSubService {
    @Resource
    BomSubMapper bomSubMapper;
    public Boolean updateOne(EnquiryBomUpdateDTO enquiryBomUpdateDTO) {
        return bomSubMapper.updateOne(enquiryBomUpdateDTO);
    }
}
