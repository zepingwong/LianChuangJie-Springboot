package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabEffectiveQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabMyQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceQuoteVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchQuotationVO;

/**
 * 采购报价
 */
public interface TabQuotationService extends IService<QuotationEntity> {
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 我的报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabMyQuotationVO> tabMyList(TabSearchDTO searchCondition);

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 有效报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabEffectiveQuotationVO> tabEffectiveList(TabSearchDTO searchCondition);


    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabEnquiryQuotationVO> enquiryTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜索-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabSearchQuotationVO> searchTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceQuoteVO> stockPriceTabList(TabSearchDTO tabSearchDTO);
}
