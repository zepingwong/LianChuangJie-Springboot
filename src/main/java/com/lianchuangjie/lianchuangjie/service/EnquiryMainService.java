package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;

public interface EnquiryMainService extends IService<EnquiryMainEntity> {
    EnquiryMainInfoVO getOne(Long docEntry);
    Page<EnquiryMainItemVO> list(EnquiryMainSearchDTO enquiryMainSearchDTO);
}
