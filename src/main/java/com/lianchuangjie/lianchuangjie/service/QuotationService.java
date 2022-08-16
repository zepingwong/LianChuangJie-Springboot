package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;

public interface QuotationService extends IService<QuotationEntity> {
    Page<QuotationVO> list(QuotationSearchDTO quotationSearchDTO);
    QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper);
}
