package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.CompanyLetterheadEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyLetterheadVO;

import java.util.List;

public interface CompanyLetterheadService extends IService<CompanyLetterheadEntity> {
    List<CompanyLetterheadVO> list(QueryWrapper<CompanyLetterheadVO> queryWrapper);
}
