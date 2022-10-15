package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabSearchPurchaseOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseOrderSubMapper extends BaseMapper<PurchaseOrderSubEntity> {
    List<TabQuotationPurchaseOrderVO> selectQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    Integer countQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    IPage<TabEnquiryPurchaseOrderVO> selectEnquiryTabList(Page<TabEnquiryPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
    IPage<TabSearchPurchaseOrderVO> selectSearchTabList(Page<TabSearchPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
}
