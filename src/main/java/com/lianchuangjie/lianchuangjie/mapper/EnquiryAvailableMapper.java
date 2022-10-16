package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryAvailableSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryAvailableVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EnquiryAvailableMapper {
    IPage<TabEnquiryAvailableVO> selectList(Page<TabEnquiryAvailableVO> page, @Param("sc") EnquiryAvailableSearchDTO searchCondition);
}
