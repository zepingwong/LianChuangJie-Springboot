package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuotationMapper extends BaseMapper<QuotationEntity> {
    IPage<QuotationVO> selectList(IPage<QuotationVO> page, @Param("ew") QueryWrapper<QuotationVO> queryWrapper, @Param("UserSign") Long userSign);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 我的报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    IPage<TabMyQuotationVO> selectMyList(IPage<TabMyQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);

    QuotationEntity selectOne(@Param("ew") QueryWrapper<QuotationEntity> queryWrapper);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 销售页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    IPage<TabEnquiryQuotationVO> selectEnquiryList(Page<TabEnquiryQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);

    /**
     * @param searchCondition searchCondition
     * @return IPage
     * @description 有效报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<TabEffectiveQuotationVO> selectEffectiveList(@Param("sc") TabSearchDTO searchCondition);

    Integer countEffectiveList(@Param("sc") TabSearchDTO searchCondition);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存定价-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    IPage<TabStockPriceQuoteVO> selectStockList(Page<TabStockPriceQuoteVO> page, @Param("sc") TabSearchDTO searchCondition);
}
