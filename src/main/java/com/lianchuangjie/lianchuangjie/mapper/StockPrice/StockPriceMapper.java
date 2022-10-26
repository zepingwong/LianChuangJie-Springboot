package com.lianchuangjie.lianchuangjie.mapper.StockPrice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceBaseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockPriceMapper extends BaseMapper<StockPriceEntity> {
    IPage<StockPriceVO> selectList(IPage<StockPriceVO> page ,@Param("sc") StockPriceSearchDTO stockPriceSearchDTO);
    Boolean update(@Param("da") StockPriceOKDTO stockPriceOKDTO);
    IPage<TabStockPriceBaseVO> tabList(Page<TabStockPriceBaseVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * 提前定价列表
     */
    List<StockPriceVO> inAdvance(@Param("modle") String modle);
}
