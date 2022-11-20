package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Stock.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryStockVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankStockVO;

public interface TabStockService extends IService<StockQuantityEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabEnquiryStockVO> enquiryTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价-原始信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价-库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabQuotationStockVO> quotationTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存排名-库存信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabStockRankStockVO> stockRankTabList(TabSearchDTO tabSearchDTO);
}
