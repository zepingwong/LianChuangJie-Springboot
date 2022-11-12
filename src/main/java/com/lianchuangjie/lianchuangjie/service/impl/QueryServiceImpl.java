package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomQueryMapper;
import com.lianchuangjie.lianchuangjie.mapper.User.UserMapper;
import com.lianchuangjie.lianchuangjie.service.QueryService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @Resource
    BomQueryMapper bomQueryMapper;
    @Resource
    UserMapper userMapper;
    
    private void setUserInfo(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        Long userSign = SessionUtil.getUser().getUserSign();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        UserEntity user = userMapper.selectOne(queryWrapper);
        enquirySingleQueryDTO.setSlpCode(userSign);
        enquirySingleQueryDTO.setDeptCode(user.getDftDept());
    }
    @Override
    public List<BomQueryItemVO> queryRelated(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        // 当前登录用户
        setUserInfo(enquirySingleQueryDTO);
        return bomQueryMapper.queryRelated(enquirySingleQueryDTO);
    }
}
