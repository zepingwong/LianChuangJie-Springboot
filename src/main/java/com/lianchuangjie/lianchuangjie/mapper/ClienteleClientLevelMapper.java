package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleClientLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleClientLevelMapper extends BaseMapper<ClienteleClientLevelEntity> {
    List<ClienteleLevelItemVO> selectList(@Param("ew") QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
