package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;

public interface EnquiryReQuoteService extends IService<EnquirySubEntity> {
    Boolean requoteService(EnquiryReQuoteDTO enquiryReQuoteDTO);
}
