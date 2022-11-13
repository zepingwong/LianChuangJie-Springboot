package com.lianchuangjie.lianchuangjie.mapper.StockRank;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockRankMapper extends BaseMapper<StockRankEntity> {
    IPage<StockRankVO> selectList(IPage<StockRankVO> page , @Param("sc") StockRankSearchDTO stockRankSearchDTO);
}
