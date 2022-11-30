package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleGroupMapper extends BaseMapper<ClienteleGroupEntity> {
    List<ClienteleGroupVO> selectList(@Param("ew") QueryWrapper<ClienteleGroupVO> queryWrapper);
}
