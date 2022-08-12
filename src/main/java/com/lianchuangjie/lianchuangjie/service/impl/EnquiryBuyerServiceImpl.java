package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryBuyerMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquiryBuyerService;
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
        if (enquiryBuyerSearchDTO.getSlpCode() == null) {
            Long userSign = SessionUtil.getUserSign();
            UserEntity user = userMapper.selectById(userSign);
            enquiryBuyerSearchDTO.setSlpCode(userSign);
            enquiryBuyerSearchDTO.setDeptCode(user.getDftDept());
        } else {
            UserEntity user = userMapper.selectById(enquiryBuyerSearchDTO.getSlpCode());
            enquiryBuyerSearchDTO.setDeptCode(user.getDftDept());
        }
        return enquiryBuyerMapper.selectList(enquiryBuyerSearchDTO);
    }
}
