package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;

import java.util.List;

public interface ClienteleSupplierService extends IService<ClienteleEntity> {
    List<ClienteleItemVO> list(String CardName);
    ClienteleInfoVO getOne(String CardCode);
}
