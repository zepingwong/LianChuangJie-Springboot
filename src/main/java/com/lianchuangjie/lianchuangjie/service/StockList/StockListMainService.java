package com.lianchuangjie.lianchuangjie.service.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListMainEntity;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListMainVO;

public interface StockListMainService extends IService<StockListMainEntity> {
    Page<StockListMainVO> list(StockListSearchDTO stockListSearchDTO);
}
