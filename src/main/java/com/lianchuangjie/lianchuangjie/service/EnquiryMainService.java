package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;

public interface EnquiryMainService {
    EnquiryMainInfoVO getMainService(Long docEntry);
    Page<EnquiryMainItemVO> getListService(EnquiryMainSearchDTO enquiryMainSearchDTO);
}
