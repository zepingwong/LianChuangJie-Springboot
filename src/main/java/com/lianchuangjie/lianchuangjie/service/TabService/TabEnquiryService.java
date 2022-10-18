package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;

/**
 * 销售报价Tab
 */
public interface TabEnquiryService extends IService<EnquirySubEntity> {
    Page<TabStockPriceEnquiryVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
