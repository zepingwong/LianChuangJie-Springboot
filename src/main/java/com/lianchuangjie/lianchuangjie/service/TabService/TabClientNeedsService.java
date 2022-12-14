package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceNeedsVO;

/**
 * 客户需求
 */
public interface TabClientNeedsService extends IService<EnquirySubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜索页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabSearchNeedsVO> searchTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-销售报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceNeedsVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
