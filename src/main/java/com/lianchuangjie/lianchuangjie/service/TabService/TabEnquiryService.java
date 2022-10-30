package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;

/**
 * 销售报价Tab
 */
public interface TabEnquiryService extends IService<EnquirySubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-销售报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabStockPriceEnquiryVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
