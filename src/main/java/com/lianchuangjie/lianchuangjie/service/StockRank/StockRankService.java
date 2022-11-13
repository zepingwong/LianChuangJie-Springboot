package com.lianchuangjie.lianchuangjie.service.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;

public interface StockRankService extends IService<StockRankEntity> {
    Page<StockRankVO> list(StockRankSearchDTO stockRankSearchDTO);
}
