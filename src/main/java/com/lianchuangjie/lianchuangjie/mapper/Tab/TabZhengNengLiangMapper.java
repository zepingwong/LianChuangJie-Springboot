package com.lianchuangjie.lianchuangjie.mapper.Tab;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankZNLVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TabZhengNengLiangMapper extends BaseMapper<ZhengNengLiangSubEntity> {
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存定价页面Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabStockPriceZNLVO> selectStockPriceTabList(Page<TabStockPriceZNLVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存排名页面Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabStockRankZNLVO> selectStockRankTabList(Page<TabStockRankZNLVO> page, @Param("sc") TabSearchDTO searchCondition);
}
