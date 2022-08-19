package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockQuantityMapper;
import com.lianchuangjie.lianchuangjie.service.StockQuantityService;
import com.lianchuangjie.lianchuangjie.vo.TabStockVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockQuantityServiceImpl extends ServiceImpl<StockQuantityMapper, StockQuantityEntity> implements StockQuantityService {
    @Resource
    StockQuantityMapper stockQuantityMapper;

    @Override
    public Page<TabStockVO> tabList(TabSearchDTO searchCondition) {
        Page<TabStockVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_OBTN.InDate"));
        stockQuantityMapper.selectTabList(page, searchCondition);
        return page;
    }
}
