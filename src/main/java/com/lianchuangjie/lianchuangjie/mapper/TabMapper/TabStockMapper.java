package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Stock.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryStockVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankStockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabStockMapper extends BaseMapper<StockQuantityEntity> {
    /**
     * @param page         page
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 销售报价-库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabEnquiryStockVO> selectEnquiryTabList(IPage<TabEnquiryStockVO> page, @Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 库存定价-原始库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<TabStockPriceOriginVO> selectStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    Integer countStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 采购报价-库存信息Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabQuotationStockVO> selectQuotationTabList(Page<TabQuotationStockVO> page, @Param("sc") TabSearchDTO searchCondition);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存排名-库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabStockRankStockVO> selectStockRankTabList(Page<TabStockRankStockVO> page, @Param("sc") TabSearchDTO searchCondition);
}
