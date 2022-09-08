package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKAllDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceBaseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockPriceMapper extends BaseMapper<StockPriceEntity> {
    List<StockPriceVO> selectList(@Param("sc") StockPriceSearchDTO stockPriceSearchDTO);
    Integer countList(@Param("sc") StockPriceSearchDTO stockPriceSearchDTO);
    Boolean update(@Param("da") StockPriceOKDTO stockPriceOKDTO);
    IPage<TabStockPriceBaseVO> tabList(Page<TabStockPriceBaseVO> page, @Param("sc") TabSearchDTO searchCondition);
    Boolean updateALL(@Param("da") StockPriceOKDTO stockPriceOKDTO);
}
