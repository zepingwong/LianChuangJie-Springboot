package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
    List<TabStockPriceOriginVO> selectStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    Integer countStockPriceTabList (@Param("sc") TabSearchDTO tabSearchDTO);

    IPage<TabQuotationStockVO> selectQuotationTabList(Page<TabQuotationStockVO> page, @Param("sc") TabSearchDTO searchCondition);
}
