package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKAllDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKDTO;
import com.lianchuangjie.lianchuangjie.dto.StockPriceOKItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.StockPriceSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPriceEntity;
import com.lianchuangjie.lianchuangjie.mapper.QuotationMapper;
import com.lianchuangjie.lianchuangjie.mapper.StockPriceMapper;
import com.lianchuangjie.lianchuangjie.service.StockPriceService;
import com.lianchuangjie.lianchuangjie.vo.StockPriceVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceBaseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockPriceServiceImpl extends ServiceImpl<StockPriceMapper, StockPriceEntity> implements StockPriceService {
    @Resource
    StockPriceMapper stockPriceMapper;

    @Override
    public Page<StockPriceVO> list(StockPriceSearchDTO searchCondition) {
        Page<StockPriceVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(stockPriceMapper.selectList(searchCondition));
        page.setTotal(stockPriceMapper.countList(searchCondition));
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
    public void updateALL(StockPriceOKAllDTO stockPriceOKAllDTO) {
        for (StockPriceOKItemDTO itemDTO : stockPriceOKAllDTO.getItems()) {
            StockPriceOKDTO stockPriceOKDTO = new StockPriceOKDTO();
            stockPriceOKDTO.setBrand(itemDTO.getBrand());
            stockPriceOKDTO.setItemName(itemDTO.getItemName());
            stockPriceOKDTO.setDocDate(stockPriceOKAllDTO.getDocDate());
            stockPriceMapper.updateALL(stockPriceOKDTO);
        }
    }
}
