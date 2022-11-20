package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomSubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomSubService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomExportVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BomSubServiceImpl extends ServiceImpl<BomSubMapper, BomSubEntity> implements BomSubService {
    @Resource
    BomSubMapper bomSubMapper;
    public Boolean updateOne(EnquiryBomUpdateDTO enquiryBomUpdateDTO) {
        return bomSubMapper.updateOne(enquiryBomUpdateDTO);
    }

    @Override
    public List<BomExportVO> export(Long docEntry) {
        return bomSubMapper.selectByDocEntry(docEntry);
    }
}
