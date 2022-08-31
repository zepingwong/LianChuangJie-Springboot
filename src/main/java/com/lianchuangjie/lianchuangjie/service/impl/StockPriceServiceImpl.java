package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPriceMapper;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockPriceServiceImpl extends ServiceImpl<StockPriceMapper, StockPriceEntity> implements StockPriceService {
    @Resource
    StockPriceMapper stockPriceMapper;
    @Override
    public Page<StockPriceVO> list(StockPriceSearchDTO searchCondition) {
        Page<StockPriceVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        stockPriceMapper.selectList(page, searchCondition);
        return page;
    }
}
