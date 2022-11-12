package com.lianchuangjie.lianchuangjie.service.StockRank.imlp;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.StockRank.StockRankLogMapper;
import com.lianchuangjie.lianchuangjie.service.StockRank.StockRankLogService;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankLogVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockRankLogServiceImpl extends ServiceImpl<StockRankLogMapper, StockRankLogEntity> implements StockRankLogService {
    @Resource
    StockRankLogMapper stockRankLogMapper;
    @Override
    public Page<StockRankLogVO> list(StockRankLogSearchDTO searchCondition) {
        Page<StockRankLogVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("U_SRAL.EndTime"));
        stockRankLogMapper.selectList(page, searchCondition);
        return page;
    }
}
