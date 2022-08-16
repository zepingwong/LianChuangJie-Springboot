package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;

import java.util.List;

public interface EnquiryBuyerService extends IService<EnquiryBuyerEntity> {
    List<EnquiryBuyerItemVO> list(EnquiryBuyerSearchDTO enquiryBuyerSearchDTO);
}
