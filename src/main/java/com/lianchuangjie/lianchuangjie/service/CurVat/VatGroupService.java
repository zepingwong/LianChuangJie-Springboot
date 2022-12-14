package com.lianchuangjie.lianchuangjie.service.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.CurVat.VatGroupVO;

import java.util.List;

public interface VatGroupService extends IService<VatGroupEntity> {
    List<VatGroupVO> list(QueryWrapper<VatGroupVO> queryWrapper);
    VatGroupVO getOne(QueryWrapper<VatGroupVO> queryWrapper);
}
