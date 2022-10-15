package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleIndustryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleIndustryMapper extends BaseMapper<ClienteleIndustryEntity> {
    List<ClienteleIndustryVO> selectList(@Param("ew") QueryWrapper<ClienteleIndustryVO> queryWrapper);
}
