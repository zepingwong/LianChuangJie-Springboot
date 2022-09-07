package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.BrandEntity;
import com.lianchuangjie.lianchuangjie.mapper.BrandMapper;
import com.lianchuangjie.lianchuangjie.service.BrandService;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {
    @Resource
    BrandMapper brandMapper;
    @Override
    public List<BrandItemVO> list(Long userSign) {
        return brandMapper.selectByBuyer(userSign);
    }

    @Override
    public List<BrandItemVO> all(String brand) {
        return brandMapper.selectAll(brand);
    }
}
