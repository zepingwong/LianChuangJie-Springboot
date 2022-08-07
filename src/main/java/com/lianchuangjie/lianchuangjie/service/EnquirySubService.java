package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;

import java.util.List;

public interface EnquirySubService {
    List<EnquirySubVO> getListService(Long docEntry);
}
