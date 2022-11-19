package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.SellerVO;

import java.util.List;

public interface SellerService {
    List<SellerVO> list(Long ownerCode);
    List<SellerVO> containList(String userName);
}
