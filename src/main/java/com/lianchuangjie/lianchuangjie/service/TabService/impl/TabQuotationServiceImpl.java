package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabQuotationMapper;
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

    @Override
    public Page<TabEnquiryQuotationVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        tabQuotationMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabSearchQuotationVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        tabQuotationMapper.selectSearchTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabStockPriceQuoteVO> stockTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceQuoteVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        tabQuotationMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }

    /**
     * @param searchCondition 查询条件
     * @return Page<TabMyQuotationVO>
     * @description 我的报价
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
     * @description 有效报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @Override
    public Page<TabEffectiveQuotationVO> tabEffectiveList(TabSearchDTO searchCondition) {
        Page<TabEffectiveQuotationVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN1.U_QuoDate"));
        page.setRecords(tabQuotationMapper.selectEffectiveTabList(searchCondition));
        page.setTotal(tabQuotationMapper.countEffectiveTabList(searchCondition));
        return page;
    }
}
