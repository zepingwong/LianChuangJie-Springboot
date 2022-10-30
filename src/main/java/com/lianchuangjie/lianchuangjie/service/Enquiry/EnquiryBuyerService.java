package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;

import java.util.List;

public interface EnquiryBuyerService extends IService<EnquiryBuyerEntity> {
    List<EnquiryBuyerItemVO> list(EnquiryBuyerSearchDTO enquiryBuyerSearchDTO);
}
