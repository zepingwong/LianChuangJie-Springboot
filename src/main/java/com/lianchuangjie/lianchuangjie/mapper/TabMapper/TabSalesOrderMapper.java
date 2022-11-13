package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankSalesOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabSalesOrderMapper extends BaseMapper<SalesOrderSubEntity> {
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 库存定价页面-销售订单List
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    IPage<TabStockPriceSalesOrderVO> selectStockPriceTabList(IPage<TabStockPriceSalesOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 库存排名页面-销售订单List
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    IPage<TabStockRankSalesOrderVO> selectStockRankTabList(IPage<TabStockRankSalesOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 采购报价页面-销售订单List
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    IPage<TabQuotationSalesOrderVO> selectQuotationTabList(IPage<TabQuotationSalesOrderVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 模糊搜索页面-销售订单List
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    List<TabSearchSalesOrderVO> selectSearchTabList(@Param("sc") TabSearchDTO searchCondition);
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 销售报价页面-销售订单List
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    List<TabEnquirySalesOrderVO> selectEnquiryTabList(@Param("sc") TabSearchDTO searchCondition);

    /**
     * @param searchCondition searchCondition
     * @return Integer
     * @description 销售报价页面-销售订单List count
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Integer countEnquiryTabList(@Param("sc") TabSearchDTO searchCondition);
}
