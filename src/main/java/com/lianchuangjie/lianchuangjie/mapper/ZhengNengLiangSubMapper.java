package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.ZhengNengLiangSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceZNLVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZhengNengLiangSubMapper extends BaseMapper<ZhengNengLiangSubEntity> {
    IPage<TabStockPriceZNLVO> tabList(Page<TabStockPriceZNLVO> page, @Param("sc") TabSearchDTO searchCondition);
}
