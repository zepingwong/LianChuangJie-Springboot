package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatCurConfEntity;
import com.lianchuangjie.lianchuangjie.vo.VatCurConfVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VatCurConfMapper extends BaseMapper<VatCurConfEntity> {
    List<VatCurConfVO> selectList(@Param("ew") QueryWrapper<VatCurConfVO> queryWrapper);
    VatCurConfVO selectOne(@Param("ew") QueryWrapper<VatCurConfVO> queryWrapper);
}
