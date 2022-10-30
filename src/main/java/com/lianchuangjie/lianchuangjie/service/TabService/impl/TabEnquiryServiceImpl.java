package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabEnquiryMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabEnquiryService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabEnquiryServiceImpl extends ServiceImpl<TabEnquiryMapper, EnquirySubEntity> implements TabEnquiryService {
    @Resource
    TabEnquiryMapper tabEnquiryMapper;
    @Override
    public Page<TabStockPriceEnquiryVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceEnquiryVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("U_ICIN1.CheckINDateT")); // 按照销售确认报价日期排序
        tabEnquiryMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }
}