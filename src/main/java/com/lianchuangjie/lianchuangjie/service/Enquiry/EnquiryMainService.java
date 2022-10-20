package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainItemVO;

public interface EnquiryMainService extends IService<EnquiryMainEntity> {
    EnquiryMainInfoVO getOne(Long docEntry);
    Page<EnquiryMainItemVO> getList(EnquiryMainSearchDTO enquiryMainSearchDTO);
}
