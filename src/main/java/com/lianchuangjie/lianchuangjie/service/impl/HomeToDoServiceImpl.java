package com.lianchuangjie.lianchuangjie.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.HomeToDoMapper;
import com.lianchuangjie.lianchuangjie.service.HomeToDoService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class HomeToDoServiceImpl implements HomeToDoService {
    @Resource
    HomeToDoMapper homeToDoMapper;

    @Override
    public Map<String, Long> getToDoNum(HttpServletRequest request) {
        Map<String, Long> map = new HashMap<>();
        Object obj = SessionUtil.getSession(request, "User");
        ObjectMapper objectMapper = new ObjectMapper();
        UserEntity user = objectMapper.convertValue(obj, UserEntity.class);
        if (Objects.equals(user.getUIsSale(), "Y")) {
            map.put("Enquiry", homeToDoMapper.countEnquiry(user.getUserSign()));
        }
        if (Objects.equals(user.getUIsBuyer(), "Y")) {
            map.put("Quotation", homeToDoMapper.countQuotation(user.getUserSign()));
        }
        return map;
    }
}
