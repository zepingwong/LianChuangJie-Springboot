package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabSearchSalesOrderVO;

public interface SalesOrderSubService extends IService<SalesOrderSubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价页面-销售订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabQuotationSalesOrderVO> quotationTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-销售订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabEnquirySalesOrderVO> enquiryTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜搜-销售订单TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabSearchSalesOrderVO> searchTabList(TabSearchDTO tabSearchDTO);
}
