package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.alibaba.fastjson.JSONArray;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.YunHan.YunHanQueryMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.YunHanService;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class YunHanServiceImpl implements YunHanService {
    @Resource
    YunHanQueryMapper yunHanQueryMapper;
    @Resource
    RedisUtil<String> redisUtil;
    @Override
    public Boolean runSendToBuyer(Long docEntry) {
        String infoStr = redisUtil.getCacheObject("Enquiry:" + docEntry);
        if (infoStr != null) {
            List<EnquirySubEntity> enquiryMatchItemVOList= JSONArray.parseArray(infoStr,EnquirySubEntity.class);
            for (EnquirySubEntity item: enquiryMatchItemVOList) {
                if (Objects.equals(item.getStatus(), "E")) {

                }
            }
        }
        return true;
    }

    @Override
    public Boolean yunHanQuery(Long docEntry) {
        return yunHanQueryMapper.insertQuery(docEntry);
    }
}
