package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabSdadaMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabSdadaService;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankSdadaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabSdadaServiceImpl extends ServiceImpl<TabSdadaMapper, SdadaEntity> implements TabSdadaService {
    @Resource
    TabSdadaMapper tabSdadaMapper;

    @Override
    public Page<TabQuotationSdadaVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationSdadaVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        tabSdadaMapper.selectQuotationSdadaTab(page, searchCondition.getModleList());
        return page;
    }

    @Override
    public Page<TabStockRankSdadaVO> stockRankTabList(TabSearchDTO searchCondition) {
        Page<TabStockRankSdadaVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        tabSdadaMapper.selectStockRankSdadaTab(page, searchCondition.getModleList());
        return page;
    }

    @Override
    public Page<TabSearchSdadaVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchSdadaVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        tabSdadaMapper.selectSearchTabList(page, searchCondition.getModleList());
        return page;
    }
}
