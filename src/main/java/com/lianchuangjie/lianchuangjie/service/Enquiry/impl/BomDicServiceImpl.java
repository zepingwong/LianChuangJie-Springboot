package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDicDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDictSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomHeadDicEntity;
import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryError;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomDicMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomDicService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomHeadDictVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BomDicServiceImpl extends ServiceImpl<BomDicMapper, BomHeadDicEntity> implements BomDicService {
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

    @Override
    public boolean add(BomHeadDicDTO bomHeadDicDTO) {
        BomHeadDicEntity bomHeadDicEntity = new BomHeadDicEntity();
        BeanUtil.copyProperties(bomHeadDicDTO, bomHeadDicEntity);
        bomHeadDicEntity.setCreateDate(new Date());
        QueryWrapper<BomHeadDicEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DicKey", bomHeadDicDTO.getDicKey());
        queryWrapper.eq("Value", bomHeadDicDTO.getValue());
        queryWrapper.eq("IsDeleted", "N");
        EnquiryError.DUPLICATE_ERROR.assertIsTrue(bomDicMapper.selectCount(queryWrapper) > 0);
        return bomDicMapper.insert(bomHeadDicEntity) == 1;
    }
}
