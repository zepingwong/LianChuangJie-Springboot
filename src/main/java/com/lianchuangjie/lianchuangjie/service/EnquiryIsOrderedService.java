package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;

public interface EnquiryIsOrderedService extends IService<EnquirySubEntity> {
    Boolean isOrderedService(EnquiryIsOrderedDTO enquiryIsOrderedDTO);
}
