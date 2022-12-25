package com.lianchuangjie.lianchuangjie.mapper.YunHan;

import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface YunHanQueryMapper {
    Boolean insertQuery(@Param("DocEntry") Long docEntry);
}
