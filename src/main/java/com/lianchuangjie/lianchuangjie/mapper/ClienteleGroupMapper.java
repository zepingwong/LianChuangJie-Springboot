package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleGroupMapper extends BaseMapper<ClienteleGroupEntity> {
    List<ClienteleGroupItemVO> selectList(@Param("ew") QueryWrapper<ClienteleGroupItemVO> queryWrapper);
}
