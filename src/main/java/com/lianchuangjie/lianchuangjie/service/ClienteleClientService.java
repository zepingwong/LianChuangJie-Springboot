package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;

import java.util.List;

public interface ClienteleClientService extends IService<ClienteleEntity> {
    List<ClienteleItemVO> list(String CardName);
    ClienteleClientInfoVO getOne(String CardCode);
}
