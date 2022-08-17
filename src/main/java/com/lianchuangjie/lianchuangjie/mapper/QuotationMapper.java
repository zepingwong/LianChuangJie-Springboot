package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabMyQuotationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuotationMapper extends BaseMapper<QuotationEntity> {
    IPage<QuotationVO> selectList(IPage<QuotationVO> page, @Param("ew") QueryWrapper<QuotationVO> queryWrapper, @Param("UserSign") Long userSign);
    IPage<TabMyQuotationVO> selectMyList(IPage<TabMyQuotationVO> page, @Param("modleList") List<String> list, @Param("UserSign") Long userSign);

    QuotationEntity selectOne(@Param("ew") QueryWrapper<QuotationEntity> queryWrapper);
}
