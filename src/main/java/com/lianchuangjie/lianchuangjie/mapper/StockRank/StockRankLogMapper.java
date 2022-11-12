package com.lianchuangjie.lianchuangjie.mapper.StockRank;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankLogEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockRankLogMapper extends BaseMapper<StockRankLogEntity> {
    IPage<StockRankLogVO> selectList(Page<StockRankLogVO> page, @Param("sc") StockRankLogSearchDTO searchCondition);
}
