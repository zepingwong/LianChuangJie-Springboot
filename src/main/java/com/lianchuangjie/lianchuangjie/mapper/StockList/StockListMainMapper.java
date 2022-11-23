package com.lianchuangjie.lianchuangjie.mapper.StockList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListMainEntity;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockListMainMapper extends BaseMapper<StockListMainEntity> {
    IPage<StockListMainVO> selectList(Page<StockListMainVO> page, @Param("sc") StockListMainSearchDTO searchCondition);
}
