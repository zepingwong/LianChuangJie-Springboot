package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchPurchaseOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TabPurchaseOrderMapper extends BaseMapper<PurchaseOrderSubEntity> {
    List<TabQuotationPurchaseOrderVO> selectQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    Integer countQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    IPage<TabEnquiryPurchaseOrderVO> selectEnquiryTabList(IPage<TabEnquiryPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
    IPage<TabSearchPurchaseOrderVO> selectSearchTabList(IPage<TabSearchPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
}
