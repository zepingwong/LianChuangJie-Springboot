package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceNeedsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabClientNeedsMapper extends BaseMapper<EnquirySubEntity> {
    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存定价-客户需求Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    IPage<TabStockPriceNeedsVO> selectStockPriceTabList(IPage<TabStockPriceNeedsVO> page, @Param("sc") TabSearchDTO searchCondition);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Integer
     * @description 销售报价页面-客户需求TAB计数
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Integer countEnquiryTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    /**
     * @param page         page
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    IPage<TabQuotationNeedsVO> selectQuotationTabList(IPage<TabQuotationNeedsVO> page, @Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    List<TabEnquiryNeedsVO> selectEnquiryTabList(@Param("sc") TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 模糊搜索-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    List<TabSearchNeedsVO> selectSearchTabList(@Param("sc") TabSearchDTO tabSearchDTO);
}
