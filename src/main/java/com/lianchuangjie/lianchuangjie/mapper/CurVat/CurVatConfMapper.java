package com.lianchuangjie.lianchuangjie.mapper.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CurVatConfMapper extends BaseMapper<CurVatConfEntity> {
    List<CurVatConfVO> selectList(@Param("ew") QueryWrapper<CurVatConfVO> queryWrapper);
    CurVatConfVO selectOne(@Param("ew") QueryWrapper<CurVatConfVO> queryWrapper);
}
