package com.lianchuangjie.lianchuangjie.service.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankLogEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankLogVO;

public interface StockRankLogService extends IService<StockRankLogEntity> {
    Page<StockRankLogVO> list(StockRankLogSearchDTO stockRankLogSearchDTO);
}
