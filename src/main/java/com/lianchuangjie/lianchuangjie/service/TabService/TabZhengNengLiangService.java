package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankZNLVO;

public interface TabZhengNengLiangService extends IService<ZhengNengLiangSubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-正能量
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabStockPriceZNLVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存排名页面-正能量
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */

    Page<TabStockRankZNLVO> stockRankTabList(TabSearchDTO tabSearchDTO);
}
