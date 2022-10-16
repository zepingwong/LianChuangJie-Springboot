package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.ZhengNengLiangSubMapper;
import com.lianchuangjie.lianchuangjie.service.ZhengNengLiangSubService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceZNLVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ZhengNengLiangSubServiceImpl extends ServiceImpl<ZhengNengLiangSubMapper, ZhengNengLiangSubEntity> implements ZhengNengLiangSubService {
    @Resource
    ZhengNengLiangSubMapper zhengNengLiangSubMapper;

    @Override
    public Page<TabStockPriceZNLVO> tabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceZNLVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        zhengNengLiangSubMapper.tabList(page, searchCondition);
        return page;
    }
}
