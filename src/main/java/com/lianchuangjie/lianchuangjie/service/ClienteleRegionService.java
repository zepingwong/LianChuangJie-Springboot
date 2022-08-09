package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;

import java.util.List;

public interface ClienteleRegionService {
    List<ClienteleRegionItemVO> getParentRegionService(Integer ParentCode);
}
