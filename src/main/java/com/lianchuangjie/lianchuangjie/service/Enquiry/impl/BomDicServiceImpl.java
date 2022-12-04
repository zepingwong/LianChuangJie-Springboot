package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDictSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomDicEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomDicMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomDicService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomHeadDictVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BomDicServiceImpl extends ServiceImpl<BomDicMapper, BomDicEntity> implements BomDicService {
    @Resource
    BomDicMapper bomDicMapper;

    @Override
    public List<String> getModleNameList() {
        QueryWrapper<String> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DicKey", "Modle");
        return bomDicMapper.selectNameList(queryWrapper);
    }

    @Override
    public List<String> getBrandNameList() {
        QueryWrapper<String> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DicKey", "Brand");
        return bomDicMapper.selectNameList(queryWrapper);
    }

    @Override
    public List<String> getRemarkNameList() {
        QueryWrapper<String> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DicKey", "Remark");
        return bomDicMapper.selectNameList(queryWrapper);
    }

    @Override
    public List<String> getQuantityNameList() {
        QueryWrapper<String> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DicKey", "Quantity");
        return bomDicMapper.selectNameList(queryWrapper);
    }

    @Override
    public Page<BomHeadDictVO> getList(BomHeadDictSearchDTO searchCondition) {
        Page<BomHeadDictVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        bomDicMapper.selectList(page, searchCondition);
        return page;
    }
}
