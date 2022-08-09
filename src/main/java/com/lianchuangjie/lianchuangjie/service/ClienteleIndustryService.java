package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.ClienteleIndustryItemVO;

import java.util.List;

public interface ClienteleIndustryService {
    List<ClienteleIndustryItemVO> getParentClienteleIndustryListService(String ParentCode);
}
