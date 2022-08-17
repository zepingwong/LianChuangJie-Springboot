package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.mapper.SdadaMapper;
import com.lianchuangjie.lianchuangjie.service.SdadaService;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SdadaServiceImpl extends ServiceImpl<SdadaMapper, SdadaEntity> implements SdadaService {
    @Resource
    SdadaMapper sdadaMapper;
    @Override
    public Page<SdadaVO> tabList(TabSearchDTO searchCondition) {
        Page<SdadaVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        sdadaMapper.selectTabList(page,searchCondition.getModleList());
        return page;
    }
}
