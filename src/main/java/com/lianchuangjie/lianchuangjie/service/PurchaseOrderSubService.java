package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationSalesOrderVO;

public interface PurchaseOrderSubService extends IService<PurchaseOrderSubEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价页面-采购订单Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabQuotationPurchaseOrderVO> quotationTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-采购订单Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabEnquiryPurchaseOrderVO> enquiryTabList(TabSearchDTO tabSearchDTO);
}
