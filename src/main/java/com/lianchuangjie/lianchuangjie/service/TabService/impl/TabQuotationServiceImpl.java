package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.mapper.Quotation.QuotationMapper;
import com.lianchuangjie.lianchuangjie.mapper.Tab.TabQuotationMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabQuotationService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabEffectiveQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabMyQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceQuoteVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchQuotationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabQuotationServiceImpl extends ServiceImpl<QuotationMapper, QuotationEntity> implements TabQuotationService {
    @Resource
    TabQuotationMapper tabQuotationMapper;
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 销售报价页面-采购报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabEnquiryQuotationVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T.U_QuoDate"));
        tabQuotationMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 模糊搜索页面-采购报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabSearchQuotationVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        tabQuotationMapper.selectSearchTabList(page, searchCondition);
        return page;
    }
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 库存定价页面-采购报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabStockPriceQuoteVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceQuoteVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(tabQuotationMapper.selectStockPriceTabList(searchCondition));
        page.setTotal(tabQuotationMapper.countStockPriceTabList(searchCondition));
        return page;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 采购报价页面-我的报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabMyQuotationVO> tabMyList(TabSearchDTO searchCondition) {
        Page<TabMyQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        tabQuotationMapper.selectMyQuotationTabList(page, searchCondition);
        return page;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 采购报价页面-有效报价Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabEffectiveQuotationVO> tabEffectiveList(TabSearchDTO searchCondition) {
        Page<TabEffectiveQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        tabQuotationMapper.selectEffectiveTabList(page ,searchCondition);
        return page;
    }
}
