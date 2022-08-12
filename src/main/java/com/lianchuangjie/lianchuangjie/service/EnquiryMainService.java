package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;

public interface EnquiryMainService {
    EnquiryMainInfoVO getOne(Long docEntry);
    Page<EnquiryMainItemVO> list(EnquiryMainSearchDTO enquiryMainSearchDTO);
}
