package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClienteleSupplierLevelMapper extends BaseMapper<ClienteleSupplierLevelEntity> {
    List<ClienteleLevelItemVO> selectList(@Param("ew") QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
