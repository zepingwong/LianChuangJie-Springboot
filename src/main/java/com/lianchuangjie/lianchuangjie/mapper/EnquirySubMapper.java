package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnquirySubMapper extends BaseMapper<EnquirySubEntity> {
    List<EnquirySubEntity> searchAllByDocEntry(
            @Param("DocEntry") Long docEntry,
            @Param("UserSign") Long userSign
    );
}
