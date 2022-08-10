package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleRegionMapper extends BaseMapper<ClienteleRegionEntity> {
    List<ClienteleRegionItemVO> selectList(@Param("ew") QueryWrapper<ClienteleRegionItemVO> queryWrapper);
}
