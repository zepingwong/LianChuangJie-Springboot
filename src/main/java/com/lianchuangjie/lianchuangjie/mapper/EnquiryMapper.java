package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EnquiryMapper extends BaseMapper<EnquiryEntity> {
    EnquiryEntity selectByDocEntry(
            @Param("DocEntry") Long docEntry,
            @Param("UserSign") Long userSign
    );
    Boolean existByDocEntry(@Param("DocEntry") Long docEntry);
}
