package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabEffectiveQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabMyQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceQuoteVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchQuotationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabQuotationMapper extends BaseMapper<QuotationEntity> {
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 采购报价页面-我的报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    IPage<TabMyQuotationVO> selectMyQuotationTabList(IPage<TabMyQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 销售页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    IPage<TabEnquiryQuotationVO> selectEnquiryTabList(Page<TabEnquiryQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 销售页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    IPage<TabSearchQuotationVO> selectSearchTabList(Page<TabSearchQuotationVO> page, @Param("sc") TabSearchDTO searchCondition);

    /**
     * @param searchCondition searchCondition
     * @return IPage
     * @description 采购报价页面-有效报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<TabEffectiveQuotationVO> selectEffectiveTabList(@Param("sc") TabSearchDTO searchCondition);

    Integer countEffectiveTabList(@Param("sc") TabSearchDTO searchCondition);
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存定价页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    IPage<TabStockPriceQuoteVO> selectStockPriceTabList(Page<TabStockPriceQuoteVO> page, @Param("sc") TabSearchDTO searchCondition);
}
