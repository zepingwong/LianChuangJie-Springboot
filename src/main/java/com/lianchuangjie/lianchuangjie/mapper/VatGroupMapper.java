package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VatGroupMapper extends BaseMapper<VatGroupEntity> {
    List<VatGroupVO> selectList(@Param("ew") QueryWrapper<VatGroupVO> queryWrapper);
    VatGroupVO selectOne(@Param("ew") QueryWrapper<VatGroupVO> queryWrapper);
}
