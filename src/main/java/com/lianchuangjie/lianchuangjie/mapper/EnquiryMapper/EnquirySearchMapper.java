package com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySearchResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EnquirySearchMapper {
    IPage<EnquirySearchResultVO> selectList(Page<EnquirySearchResultVO> page, @Param("sc") EnquirySearchDTO searchCondition);
}
