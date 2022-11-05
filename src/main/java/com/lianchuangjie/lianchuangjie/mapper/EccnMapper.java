package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.vo.EccnVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EccnMapper {
    List<EccnVO> selectList();
}
