package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabMyQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabSalesOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalesOrderSubMapper extends BaseMapper<SalesOrderSubEntity> {
    IPage<TabSalesOrderVO> selectTabList(Page<TabSalesOrderVO> page, List<String> modleList, Long userSign);
}
