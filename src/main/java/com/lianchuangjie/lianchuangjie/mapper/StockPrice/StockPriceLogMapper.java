package com.lianchuangjie.lianchuangjie.mapper.StockPrice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockPrice.StockPriceLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockPrice.StockPriceLogEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.StockPriceLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockPriceLogMapper extends BaseMapper<StockPriceLogEntity> {
    IPage<StockPriceLogVO> selectList(Page<StockPriceLogVO> page, @Param("sc") StockPriceLogSearchDTO stockPriceLogSearchDTO);
}
