package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CompanyLetterheadEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyLetterheadVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CompanyLetterheadMapper extends BaseMapper<CompanyLetterheadEntity> {
    List<CompanyLetterheadVO> selectList(
            @Param("UserSign") Long UserSign
    );
}
