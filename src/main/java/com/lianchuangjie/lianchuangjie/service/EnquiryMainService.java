package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainVO;

public interface EnquiryMainService {
    EnquiryMainVO getMainService(Long docEntry);
    Page<EnquiryMainVO> getListService(EnquiryMainSearchDTO enquiryMainSearchDTO);
}
