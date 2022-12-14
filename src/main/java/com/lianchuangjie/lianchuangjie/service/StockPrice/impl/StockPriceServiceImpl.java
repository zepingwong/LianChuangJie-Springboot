package com.lianchuangjie.lianchuangjie.service.StockPrice.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockPrice.StockPriceMapper;
import com.lianchuangjie.lianchuangjie.service.StockPrice.StockPriceService;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceBaseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Boolean update(StockPriceOKDTO stockPriceOKDTO) {
        return stockPriceMapper.update(stockPriceOKDTO);
    }

    @Override
    public Page<TabStockPriceBaseVO> tabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceBaseVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        stockPriceMapper.tabList(page, searchCondition);
        return page;
    }

    @Override
    public void updateALL(List<StockPriceOKDTO> list) {
        for (StockPriceOKDTO itemDTO : list) {
            stockPriceMapper.update(itemDTO);
        }
    }

    @Override
    public List<StockPriceVO> inAdvanceList(String modle) {
        return stockPriceMapper.inAdvance(modle);
    }
}
