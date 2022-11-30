package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.SellerVO;

import java.util.List;

public interface SellerService {
    List<SellerVO> list(Long ownerCode);

    /**
     * @param userName userName
     * @return List
     * @description 搜索建议
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<SellerVO> containList(String userName);
}
