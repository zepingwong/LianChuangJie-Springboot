package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
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
        tabEnquiryMapper.selectStockPriceTabList(page, searchCondition);
        System.out.println("**************************************");
        System.out.println(page);
        return page;
    }
}