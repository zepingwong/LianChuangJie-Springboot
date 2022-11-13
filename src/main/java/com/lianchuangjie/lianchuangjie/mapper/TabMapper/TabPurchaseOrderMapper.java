package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPricePurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankPurchaseOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabPurchaseOrderMapper extends BaseMapper<PurchaseOrderSubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return List
     * @description 采购报价-采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<TabQuotationPurchaseOrderVO> selectQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    Integer countQuotationTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return List
     * @description 库存定价-采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<TabStockPricePurchaseOrderVO> selectStockPriceTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return List
     * @description 库存排名-采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<TabStockRankPurchaseOrderVO> selectStockRankTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 询价页面-采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabEnquiryPurchaseOrderVO> selectEnquiryTabList(IPage<TabEnquiryPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 模糊搜索页面-采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabSearchPurchaseOrderVO> selectSearchTabList(IPage<TabSearchPurchaseOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
}
