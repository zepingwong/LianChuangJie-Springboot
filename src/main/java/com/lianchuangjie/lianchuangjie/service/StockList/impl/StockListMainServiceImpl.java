package com.lianchuangjie.lianchuangjie.service.StockList.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListMainMapper;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListMainService;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListMainVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockListMainServiceImpl extends ServiceImpl<StockListMainMapper, StockListMainEntity> implements StockListMainService {
    @Resource
    StockListMainMapper stockListMainMapper;
    @Override
    public Page<StockListMainVO> list(StockListMainSearchDTO searchCondition) {
        Page<StockListMainVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T.CreateDate"));
        stockListMainMapper.selectList(page, searchCondition);
        return page;
    }
}
