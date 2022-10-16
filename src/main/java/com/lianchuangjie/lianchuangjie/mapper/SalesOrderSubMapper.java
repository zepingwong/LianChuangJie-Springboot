package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabSearchSalesOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalesOrderSubMapper extends BaseMapper<SalesOrderSubEntity> {
    IPage<TabQuotationSalesOrderVO> selectQuotationTabList(Page<TabQuotationSalesOrderVO> page, @Param("sc") TabSearchDTO tabSearchDTO);
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

    /**
     * @param cardName cardName
     * @return Boolean
     * @description 判断是否为老客户，只有下过单的才为老客户
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    Boolean existByCardName(@Param("CardName") String cardName);
}
