package com.lianchuangjie.lianchuangjie.service.StockPrice.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceLogMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceLogService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceLogVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockPriceLogServiceImpl extends ServiceImpl<StockPriceLogMapper, StockPriceLogEntity> implements StockPriceLogService {
    @Resource
    StockPriceLogMapper stockPriceLogMapper;
    @Override
    public Page<StockPriceLogVO> list(StockPriceLogSearchDTO searchCondition) {
        Page<StockPriceLogVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("U_SPAL.EndTime"));
        stockPriceLogMapper.selectList(page, searchCondition);
        return page;
    }
}
