package com.lianchuangjie.lianchuangjie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HomeToDoMapper {
    Long countEnquiry(@Param("UserSign") Long userSign);
    Long countQuotation(@Param("UserSign") Long userSign);
}
