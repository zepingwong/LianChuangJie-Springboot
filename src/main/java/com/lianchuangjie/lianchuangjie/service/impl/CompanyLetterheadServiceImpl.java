package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CompanyLetterheadEntity;
import com.lianchuangjie.lianchuangjie.mapper.Company.CompanyLetterheadMapper;
import com.lianchuangjie.lianchuangjie.service.CompanyLetterheadService;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.vo.CompanyLetterheadVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyLetterheadServiceImpl extends ServiceImpl<CompanyLetterheadMapper, CompanyLetterheadEntity> implements CompanyLetterheadService {
    @Resource
    CompanyLetterheadMapper companyLetterheadMapper;

    @Override
    public List<CompanyLetterheadVO> list(QueryWrapper<CompanyLetterheadVO> queryWrapper) {
        return companyLetterheadMapper.selectList(ContextUtil.getUser().getUserSign());
    }
}
