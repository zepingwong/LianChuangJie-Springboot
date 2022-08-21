package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationSalesOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalesOrderSubMapper extends BaseMapper<SalesOrderSubEntity> {
    IPage<TabQuotationSalesOrderVO> selectQuotationTabList(Page<TabQuotationSalesOrderVO> page, @Param("sc") TabSearchDTO tabSearchDTO);

    List<TabEnquirySalesOrderVO> selectEnquiryTabList(@Param("sc") TabSearchDTO searchCondition);
}
