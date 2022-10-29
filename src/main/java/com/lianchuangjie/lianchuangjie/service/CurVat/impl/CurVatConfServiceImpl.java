package com.lianchuangjie.lianchuangjie.service.CurVat.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.CurVat.CurVatSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.mapper.CurVat.CurVatConfMapper;
import com.lianchuangjie.lianchuangjie.service.CurVat.CurVatConfService;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CurVatConfServiceImpl extends ServiceImpl<CurVatConfMapper, CurVatConfEntity> implements CurVatConfService {
    @Resource
    CurVatConfMapper curVatConfMapper;
    @Override
    public List<CurVatConfVO> list(CurVatSearchDTO curVatSearchDTO) {
        return curVatConfMapper.selectList(curVatSearchDTO);
    }

    @Override
    public CurVatConfVO getOne(QueryWrapper<CurVatConfVO> queryWrapper) {
        return curVatConfMapper.selectOne(queryWrapper);
    }
}
