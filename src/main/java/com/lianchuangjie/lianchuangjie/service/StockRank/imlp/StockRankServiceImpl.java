package com.lianchuangjie.lianchuangjie.service.StockRank.imlp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockRank.StockRankMapper;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankService;
import com.lianchuangjie.lianchuangjie.vo.StockRank.PurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StockRankServiceImpl extends ServiceImpl<StockRankMapper, StockRankEntity> implements StockRankService {
    @Resource
    StockRankMapper stockRankMapper;

    @Override
    public Page<StockRankVO> list(StockRankSearchDTO searchCondition) {
        Page<StockRankVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        stockRankMapper.selectList(page, searchCondition);
        return page;
    }

    @Override
    public List<BigDecimal> purchasePriceList(String modle) {
        return stockRankMapper.selectPurchasePrice(modle);
    }

    @Override
    public List<PurchaseOrderVO> purchaseOrderList(StockRankSearchDTO stockRankSearchDTO) {
        List<PurchaseOrderVO> list = stockRankMapper.selectPurchaseOrder(stockRankSearchDTO);
        return list;
    }
}
