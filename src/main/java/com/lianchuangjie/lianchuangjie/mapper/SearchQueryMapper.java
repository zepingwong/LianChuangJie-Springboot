package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySearchDTO;
import com.lianchuangjie.lianchuangjie.vo.SearchQueryVO;
import org.apache.ibatis.annotations.Param;


public interface SearchQueryMapper {
    IPage<SearchQueryVO> selectList(IPage<SearchQueryVO> page, @Param("sc") EnquirySearchDTO enquirySearchDTO);
}
