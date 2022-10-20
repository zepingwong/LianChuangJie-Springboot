package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquiryBuyerMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryBuyerService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
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
            user = SessionUtil.getUser();
            enquiryBuyerSearchDTO.setSlpCode(user.getUserSign());
        } else {
            user = userMapper.selectById(enquiryBuyerSearchDTO.getSlpCode());
        }
        enquiryBuyerSearchDTO.setDeptCode(user.getDftDept());
        return enquiryBuyerMapper.selectList(enquiryBuyerSearchDTO);
    }
}
