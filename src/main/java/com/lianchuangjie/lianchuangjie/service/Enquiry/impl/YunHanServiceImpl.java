package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.mapper.YunHan.YunHanQueryMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.YunHanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YunHanServiceImpl implements YunHanService {
    @Resource
    YunHanQueryMapper yunHanQueryMapper;
    @Override
    public Boolean runSendToBuyer() {
        return null;
    }

    @Override
    public Boolean yunHanQuery(Long docEntry) {
        return yunHanQueryMapper.insertQuery(docEntry);
    }
}
