package com.lianchuangjie.lianchuangjie.mapper.Stock;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Stock.StockQuantityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockQuantityMapper extends BaseMapper<StockQuantityEntity> {
}
