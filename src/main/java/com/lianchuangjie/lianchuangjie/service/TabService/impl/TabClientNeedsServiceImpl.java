package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabClientNeedsMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabClientNeedsService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceNeedsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabClientNeedsServiceImpl extends ServiceImpl<TabClientNeedsMapper, EnquirySubEntity> implements TabClientNeedsService {
    @Resource
    TabClientNeedsMapper tabClientNeedsMapper;

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        tabClientNeedsMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(tabClientNeedsMapper.selectEnquiryTabList(searchCondition));
        page.setTotal(tabClientNeedsMapper.countEnquiryTabList(searchCondition));
        return page;
    }
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 模糊搜索页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabSearchNeedsVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(tabClientNeedsMapper.selectSearchTabList(searchCondition));
        page.setTotal(tabClientNeedsMapper.countEnquiryTabList(searchCondition));
        return page;
    }
    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 库存定价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabStockPriceNeedsVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        tabClientNeedsMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }
}
