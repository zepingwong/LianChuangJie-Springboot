package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleGroupItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClienteleGroupMapper extends BaseMapper<ClienteleGroupEntity> {
    List<ClienteleGroupItemVO> queryByType(@Param("Type") String Type);
}
