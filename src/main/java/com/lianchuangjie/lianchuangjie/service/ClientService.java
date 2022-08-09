package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.ClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;

import java.util.List;

public interface ClientService {
    List<ClienteleItemVO> queryListService(String CardName);
    ClientInfoVO queryInfoService(String CardCode);
}
