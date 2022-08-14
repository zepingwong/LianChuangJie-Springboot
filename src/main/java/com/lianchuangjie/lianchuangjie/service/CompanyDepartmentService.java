package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.CompanyDepartmentEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyDepartmentVO;

import java.util.List;

public interface CompanyDepartmentService extends IService<CompanyDepartmentEntity> {
    List<CompanyDepartmentVO> list(QueryWrapper<CompanyDepartmentVO> queryWrapper);
}
