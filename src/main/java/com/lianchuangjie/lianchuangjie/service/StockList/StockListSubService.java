package com.lianchuangjie.lianchuangjie.service.StockList;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;

public interface StockListSubService extends IService<StockListSubEntity> {
    Page<StockListSubVO> list(StockListSubSearchDTO stockListSubSearchDTO);
}
