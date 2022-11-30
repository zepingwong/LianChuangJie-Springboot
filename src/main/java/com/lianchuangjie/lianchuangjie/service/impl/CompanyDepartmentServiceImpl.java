package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CompanyDepartmentEntity;
import com.lianchuangjie.lianchuangjie.mapper.Company.CompanyDepartmentMapper;
import com.lianchuangjie.lianchuangjie.service.CompanyDepartmentService;
import com.lianchuangjie.lianchuangjie.vo.CompanyDepartmentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyDepartmentServiceImpl extends ServiceImpl<CompanyDepartmentMapper, CompanyDepartmentEntity> implements CompanyDepartmentService {
    @Resource
    CompanyDepartmentMapper companyDepartmentMapper;
    @Override
    public List<CompanyDepartmentVO> list(QueryWrapper<CompanyDepartmentVO> queryWrapper) {
        return companyDepartmentMapper.selectList(queryWrapper);
    }
}
