package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabEffectiveQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabMyQuotationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuotationMapper extends BaseMapper<QuotationEntity> {
    IPage<QuotationVO> selectList(IPage<QuotationVO> page, @Param("ew") QueryWrapper<QuotationVO> queryWrapper, @Param("UserSign") Long userSign);
    IPage<TabMyQuotationVO> selectMyList(IPage<TabMyQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);
    QuotationEntity selectOne(@Param("ew") QueryWrapper<QuotationEntity> queryWrapper);

    IPage<TabEnquiryQuotationVO> selectEnquiryList(Page<TabEnquiryQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);

    List<TabEffectiveQuotationVO> selectEffectiveList(@Param("sc") TabSearchDTO searchCondition);
    Integer countEffectiveList(@Param("sc") TabSearchDTO searchCondition);
}
