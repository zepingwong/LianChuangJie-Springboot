package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryAvailableSearchDTO;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryAvailableMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryAvailableService;
import com.lianchuangjie.lianchuangjie.utils.HttpUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryAvailableVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class EnquiryAvailableServiceImpl implements EnquiryAvailableService {
    @Resource
    EnquiryAvailableMapper enquiryAvailableMapper;
    @Value("${algorithm_address}")
    private String address;
    @Override
    public Page<TabEnquiryAvailableVO> list(EnquiryAvailableSearchDTO searchCondition) {
        Page<TabEnquiryAvailableVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquiryAvailableMapper.selectList(page, searchCondition);
        System.out.println(page.getRecords().get(0).getDemandQty());
        JSONObject json = new JSONObject();
        json.put("data", page.getRecords());
        System.out.println(json);
        String res;
        try {
            res = HttpUtil.jsonPost(address + "reco_price", null, json);
            JSONObject object = JSONObject.parseObject(res);
            System.out.println(JSON.parseArray(object.getString("data")));
            page.setRecords(JSON.parseArray(object.getString("data"), TabEnquiryAvailableVO.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return page;
    }
}
