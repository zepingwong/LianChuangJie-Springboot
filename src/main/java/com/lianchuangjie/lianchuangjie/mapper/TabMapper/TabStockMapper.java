package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryStockVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabStockMapper extends BaseMapper<StockQuantityEntity> {
    IPage<TabEnquiryStockVO> selectEnquiryTabList(IPage<TabEnquiryStockVO> page, @Param("sc") TabSearchDTO tabSearchDTO);
    List<TabStockPriceOriginVO> selectStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    Integer countStockPriceTabList (@Param("sc") TabSearchDTO tabSearchDTO);

    IPage<TabQuotationStockVO> selectQuotationTabList(Page<TabQuotationStockVO> page, @Param("sc") TabSearchDTO searchCondition);
}
