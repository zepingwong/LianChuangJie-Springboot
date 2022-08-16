package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleSupplierInfoVO;

import java.util.List;

public interface ClienteleSupplierService extends IService<ClienteleEntity> {
    List<ClienteleItemVO> list(String CardName);
    ClienteleSupplierInfoVO getOne(String CardCode);
}
