package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;

import java.util.List;

public interface ClienteleGroupService {
    List<ClienteleGroupItemVO> getClienteleGroupListService(String Type);
}
