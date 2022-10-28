package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatCurConfEntity;
import com.lianchuangjie.lianchuangjie.mapper.VatCurConfMapper;
import com.lianchuangjie.lianchuangjie.service.VatCurConfService;
import com.lianchuangjie.lianchuangjie.vo.VatCur.VatCurConfVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VatCurConfServiceImpl extends ServiceImpl<VatCurConfMapper, VatCurConfEntity> implements VatCurConfService {
    @Resource
    VatCurConfMapper vatCurConfMapper;
    @Override
    public List<VatCurConfVO> list(QueryWrapper<VatCurConfVO> queryWrapper) {
        return vatCurConfMapper.selectList(queryWrapper);
    }

    @Override
    public VatCurConfVO getOne(QueryWrapper<VatCurConfVO> queryWrapper) {
        return vatCurConfMapper.selectOne(queryWrapper);
    }
}
