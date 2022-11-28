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
    /**
     * @param page                page
     * @param stockPriceSearchDTO stockPriceSearchDTO
     * @return IPage
     * @description 查询列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/29/2022
     */
    IPage<StockPriceVO> selectList(IPage<StockPriceVO> page, @Param("sc") StockPriceSearchDTO stockPriceSearchDTO);

    /**
     * @param stockPriceOKDTO stockPriceOKDTO
     * @return Boolean
     * @description 确认定价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/29/2022
     */

    Boolean update(@Param("da") StockPriceOKDTO stockPriceOKDTO);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/29/2022
     */

    IPage<TabStockPriceBaseVO> tabList(Page<TabStockPriceBaseVO> page, @Param("sc") TabSearchDTO searchCondition);

    /**
     * @param modle modle
     * @return List
     * @description 提前定价列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/29/2022
     */
    List<StockPriceVO> inAdvance(@Param("modle") String modle);
}
