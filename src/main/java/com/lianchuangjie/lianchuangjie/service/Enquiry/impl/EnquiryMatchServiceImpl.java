package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquirySingleMatchMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMatchService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquiryMatchServiceImpl implements EnquiryMatchService {
    @Resource
    EnquirySingleMatchMapper enquirySingleMatchMapper;
    private void setUserInfo(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        UserEntity user = SessionUtil.getUser();
        enquirySingleQueryDTO.setSlpCode(user.getUserSign());
        enquirySingleQueryDTO.setDeptCode(user.getDftDept());
    }
    @Override
    public List<EnquiryMatchItemVO> querySingle(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        // 当前登录用户
        setUserInfo(enquirySingleQueryDTO);
        return enquirySingleMatchMapper.query(enquirySingleQueryDTO);
    }
}
