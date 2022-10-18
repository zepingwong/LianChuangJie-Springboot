package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabClientNeedsMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabEnquiryService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;
import org.springframework.stereotype.Service;

@Service
public class TabEnquiryServiceImpl extends ServiceImpl<TabClientNeedsMapper, EnquirySubEntity> implements TabEnquiryService {
    @Override
    public Page<TabStockPriceEnquiryVO> stockPriceTabList(TabSearchDTO tabSearchDTO) {
        return null;
    }
}
