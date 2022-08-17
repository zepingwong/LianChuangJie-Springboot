package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.entity.StockQuantityEntity;
import com.lianchuangjie.lianchuangjie.vo.TabStockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockQuantityMapper extends BaseMapper<StockQuantityEntity> {
    IPage<TabStockVO> selectTabList(IPage<TabStockVO> page, @Param("modleList") List<String> list, @Param("UserSign") Long userSign);
}
