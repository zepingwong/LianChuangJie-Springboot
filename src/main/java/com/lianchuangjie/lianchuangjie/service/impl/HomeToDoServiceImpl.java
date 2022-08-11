package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.service.HomeToDoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class HomeToDoServiceImpl implements HomeToDoService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Override
    public Map<String, Long> getTodoNum(Long userSign) {
        QueryWrapper<EnquiryMainEntity> enquiryQueryWrapper = new QueryWrapper<>();
        enquiryQueryWrapper.eq("OwnerCode", userSign);
        enquiryQueryWrapper.isNotNull("State");
        Long enquiryNum = enquiryMainMapper.selectCount(enquiryQueryWrapper);
        HashMap<String, Long> map = new HashMap<>();
        map.put("Enquiry", enquiryNum);
        map.put("Quotation", 0L);
        return map;
    }
}
