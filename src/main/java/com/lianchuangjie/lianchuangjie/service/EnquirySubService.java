package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;

import java.util.List;

public interface EnquirySubService extends IService<EnquirySubEntity> {
    List<EnquirySubVO> list(Long docEntry);
    Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO tabSearchDTO);

    Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO tabSearchDTO);
}
