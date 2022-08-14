package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.BrandEntity;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;

import java.util.List;

public interface BrandService extends IService<BrandEntity> {
    List<BrandItemVO> list(Long userSign);
}
