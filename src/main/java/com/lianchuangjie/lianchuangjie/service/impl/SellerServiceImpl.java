package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.mapper.SellerMapper;
import com.lianchuangjie.lianchuangjie.service.SellerService;
import com.lianchuangjie.lianchuangjie.vo.SellerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Resource
    SellerMapper sellerMapper;
    @Override
    public List<SellerVO> list(Long userSign) {
        return sellerMapper.selectByBuyer(userSign);
    }

    @Override
    public List<SellerVO> containList(String userName) {
        return sellerMapper.selectContain(userName);
    }
}
