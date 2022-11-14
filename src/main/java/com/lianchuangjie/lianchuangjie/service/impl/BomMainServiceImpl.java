package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomMainMapper;
import com.lianchuangjie.lianchuangjie.service.BomMainService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomMainVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BomMainServiceImpl extends ServiceImpl<BomMainMapper, BomMainEntity> implements BomMainService {
    @Resource
    BomMainMapper bomMainMapper;
    @Override
    public Page<BomMainVO> list(BomMainSearchDTO searchCondition) {
        Page<BomMainVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        bomMainMapper.selectList(page, searchCondition);
        return page;
    }
}
