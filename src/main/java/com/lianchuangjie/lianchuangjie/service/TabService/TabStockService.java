package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryStockVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationStockVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceOriginVO;

public interface TabStockService extends IService<StockQuantityEntity> {
    Page<TabEnquiryStockVO> enquiryTabList(TabSearchDTO tabSearchDTO);
    Page<TabStockPriceOriginVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
    Page<TabQuotationStockVO> quotationTabList(TabSearchDTO tabSearchDTO);
}
