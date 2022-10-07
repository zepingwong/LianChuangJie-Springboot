package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceOriginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
    List<TabStockPriceOriginVO> selectStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    Integer countStockPriceTabList (@Param("sc") TabSearchDTO tabSearchDTO);
}
