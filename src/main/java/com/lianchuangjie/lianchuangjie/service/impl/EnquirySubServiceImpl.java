package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EnquirySubServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquirySubService {
    @Resource
    EnquirySubMapper enquirySubMapper;
    @Override
    public List<EnquirySubVO> list(Long docEntry) {
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<EnquirySubVO> queryWrapper = new QueryWrapper<>();
        String mainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        String subTable = SqlHelper.table(EnquirySubEntity.class).getTableName();
        queryWrapper.eq(subTable + ".DocEntry", docEntry);
        queryWrapper.eq(mainTable + ".OwnerCode", userSign);
        return enquirySubMapper.selectList(queryWrapper);
    }
}
