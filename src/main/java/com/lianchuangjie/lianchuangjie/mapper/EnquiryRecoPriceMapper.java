package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.dto.search.RecoPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryRecoPriceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnquiryRecoPriceMapper {
    List<EnquiryRecoPriceVO> selectList(@Param("sc") RecoPriceSearchDTO recoPriceSearchDTO);
}
