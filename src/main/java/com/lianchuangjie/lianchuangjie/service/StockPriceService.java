package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceBaseVO;

import java.util.List;

public interface StockPriceService extends IService<StockPriceEntity> {
    Page<StockPriceVO> list(StockPriceSearchDTO stockPriceSearchDTO);

    Boolean update(StockPriceOKDTO stockPriceOKDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-基本信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceBaseVO> tabList(TabSearchDTO tabSearchDTO);

    /**
     * @description 一键OK
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    void updateALL(List<StockPriceOKDTO> list);
}
