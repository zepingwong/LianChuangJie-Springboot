package com.lianchuangjie.lianchuangjie.service.StockList.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListSubMapper;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockListSubServiceImpl extends ServiceImpl<StockListSubMapper, StockListSubEntity> implements StockListSubService {
    @Resource
    StockListSubMapper stockListSubMapper;
    @Override
    public Page<StockListSubVO> list(StockListSubSearchDTO searchCondition) {
        Page<StockListSubVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.asc("U_StockList1.LineNum"));
        stockListSubMapper.selectList(page, searchCondition);
        return page;
    }
}
