package com.lianchuangjie.lianchuangjie.service.StockList.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListCompleteDTO;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListSubMapper;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListExportVO;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockListSubServiceImpl extends ServiceImpl<StockListSubMapper, StockListSubEntity> implements StockListSubService {
    @Resource
    StockListSubMapper stockListSubMapper;

    @Override
    public Page<StockListSubVO> list(StockListSubSearchDTO searchCondition) {
        Page<StockListSubVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.asc("TT.LineNum"));
        stockListSubMapper.selectList(page, searchCondition);
        return page;
    }

    @Override
    public Boolean complete(List<StockListCompleteDTO> stockListSubVolumes) {
        for (StockListCompleteDTO item : stockListSubVolumes) {
            stockListSubMapper.complete(item);
        }
        return null;
    }

    @Override
    public List<StockListExportVO> export(Long docEntry, Integer type) {
        return stockListSubMapper.export(docEntry, type);
    }
}
