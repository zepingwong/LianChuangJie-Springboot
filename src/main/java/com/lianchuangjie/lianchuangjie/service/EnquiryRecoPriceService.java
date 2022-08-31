package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.search.RecoPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryRecoPriceVO;

import java.util.List;

public interface EnquiryRecoPriceService {
    List<EnquiryRecoPriceVO> list(RecoPriceSearchDTO recoPriceSearchDTO);
}
