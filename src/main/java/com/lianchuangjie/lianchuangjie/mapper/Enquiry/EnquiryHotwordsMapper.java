package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryHotwordsVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquiryHotwordsMapper {
    List<EnquiryHotwordsVO> selectList();
}
