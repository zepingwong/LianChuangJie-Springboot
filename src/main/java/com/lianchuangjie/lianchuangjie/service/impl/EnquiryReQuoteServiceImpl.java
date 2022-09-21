package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.service.EnquiryReQuoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryReQuoteServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquiryReQuoteService {
    @Resource
    QuotationMapper quotationMapper;
    @Resource
    EnquirySubMapper enquirySubMapper;

    @Override
    public Boolean requoteService(EnquiryReQuoteDTO enquiryReQuoteDTO) {
        EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(enquiryReQuoteDTO.getDocEntry(), enquiryReQuoteDTO.getLineNum());
        String buyers = enquirySubEntity.getBuyers();
        if (!buyers.contains(String.valueOf(enquiryReQuoteDTO.getUBuyer()))) {
            buyers = buyers + "," + enquiryReQuoteDTO.getUBuyer();
        }
        enquirySubEntity.setBuyers(buyers);
        enquirySubMapper.updateBuyers(enquirySubEntity);
        // 采购报价表直接保存此条报价信息
        QueryWrapper<QuotationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DocEntry", enquiryReQuoteDTO.getBaseEntry());
        queryWrapper.eq("LineNum", enquiryReQuoteDTO.getBaseLine());
        QuotationEntity quotationEntity = quotationMapper.selectOne(queryWrapper);
        quotationEntity.setDocEntry(enquiryReQuoteDTO.getDocEntry());
        Long lineNum = quotationMapper.count(enquiryReQuoteDTO.getDocEntry()) + 1;
        quotationEntity.setLineNum(lineNum);
        quotationEntity.setDocEntry(enquiryReQuoteDTO.getDocEntry());
        quotationEntity.setUStatus(String.valueOf('U'));
        quotationMapper.insert(quotationEntity);
        return true;
    }
}
