package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryBuyerMapper;
import com.lianchuangjie.lianchuangjie.mapper.User.UserMapper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryBuyerService;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquiryBuyerServiceImpl extends ServiceImpl<EnquiryBuyerMapper, EnquiryBuyerEntity> implements EnquiryBuyerService {
    @Resource
    EnquiryBuyerMapper enquiryBuyerMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public List<EnquiryBuyerItemVO> list(EnquiryBuyerSearchDTO enquiryBuyerSearchDTO) {
        UserEntity user;
        if (enquiryBuyerSearchDTO.getSlpCode() == null) {
            user = ContextUtil.getUser();
            enquiryBuyerSearchDTO.setSlpCode(user.getUserSign());
        } else {
            user = userMapper.selectById(enquiryBuyerSearchDTO.getSlpCode());
        }
        enquiryBuyerSearchDTO.setDeptCode(user.getDftDept());
        return enquiryBuyerMapper.selectList(enquiryBuyerSearchDTO);
    }
}
