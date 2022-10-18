package com.lianchuangjie.lianchuangjie.service.TabService.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.TabMapper.TabZhengNengLiangMapper;
import com.lianchuangjie.lianchuangjie.mapper.ZhengNengLiangSubMapper;
import com.lianchuangjie.lianchuangjie.service.TabService.TabZhengNengLiangService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabZhengNengLiangServiceImpl extends ServiceImpl<ZhengNengLiangSubMapper, ZhengNengLiangSubEntity> implements TabZhengNengLiangService {
    @Resource
    TabZhengNengLiangMapper tabZhengNengLiangMapper;

    @Override
    public Page<TabStockPriceZNLVO> stockPriceTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceZNLVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        tabZhengNengLiangMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }
}
