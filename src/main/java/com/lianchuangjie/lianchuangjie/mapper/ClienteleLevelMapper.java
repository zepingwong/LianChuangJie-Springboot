package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClienteleLevelMapper {
    List<ClienteleLevelItemVO> queryByType(@Param("Type") String Type);
}
