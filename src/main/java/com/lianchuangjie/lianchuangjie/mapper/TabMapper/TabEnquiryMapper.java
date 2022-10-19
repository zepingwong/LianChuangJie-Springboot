package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TabEnquiryMapper extends BaseMapper<EnquirySubEntity> {
    IPage<TabStockPriceEnquiryVO> selectStockPriceTabList(IPage<TabStockPriceEnquiryVO> page, @Param("sc") TabSearchDTO searchCondition);
}
