package com.lianchuangjie.lianchuangjie.mapper.StockList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSelectDTO;
import com.lianchuangjie.lianchuangjie.dto.StockList.StockListSubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListExportVO;
import com.lianchuangjie.lianchuangjie.vo.StockList.StockListSubVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockListSubMapper extends BaseMapper<StockListSubEntity> {
    IPage<StockListSubVO> selectList(Page<StockListSubVO> page, @Param("sc") StockListSubSearchDTO searchCondition);
    Boolean select(@Param("da") StockListSelectDTO item);
    Boolean unSelect(@Param("da") StockListSelectDTO item);

    List<StockListExportVO> export(@Param("DocEntry") Long docEntry, @Param("type") Integer type);
}
