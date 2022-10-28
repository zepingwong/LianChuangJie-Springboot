package com.lianchuangjie.lianchuangjie.service.CurVat.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.mapper.CurVat.VatGroupMapper;
import com.lianchuangjie.lianchuangjie.service.CurVat.VatGroupService;
import com.lianchuangjie.lianchuangjie.vo.CurVat.VatGroupVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VatGroupServiceImpl extends ServiceImpl<VatGroupMapper, VatGroupEntity> implements VatGroupService {
    @Resource
    VatGroupMapper vatGroupMapper;
    @Override
    public List<VatGroupVO> list(QueryWrapper<VatGroupVO> queryWrapper) {
        return vatGroupMapper.selectList(queryWrapper);
    }
    @Override
    public VatGroupVO getOne(QueryWrapper<VatGroupVO> queryWrapper) {
        return vatGroupMapper.selectOne(queryWrapper);
    }
}
