package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.mapper.SdadaMapper;
import com.lianchuangjie.lianchuangjie.service.SdadaService;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SdadaServiceImpl extends ServiceImpl<SdadaMapper, SdadaEntity> implements SdadaService {
    @Resource
    SdadaMapper sdadaMapper;

    @Override
    public List<SdadaVO> containList(String modle) {
        return sdadaMapper.selectContain(modle);
    }

    @Override
    public List<SdadaVO> relatedList(String modle) {
        return sdadaMapper.selectRelated(modle);
    }
}
