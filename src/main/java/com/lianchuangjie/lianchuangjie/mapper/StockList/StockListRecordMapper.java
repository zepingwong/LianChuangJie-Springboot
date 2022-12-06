package com.lianchuangjie.lianchuangjie.mapper.StockList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockListRecordMapper extends BaseMapper<StockListRecordEntity> {
    void match(@Param("DocEntry") Long docEntry);
}
