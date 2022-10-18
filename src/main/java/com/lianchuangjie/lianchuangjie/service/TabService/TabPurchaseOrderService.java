package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchPurchaseOrderVO;

/**
 * 采购订单
 */
public interface TabPurchaseOrderService extends IService<PurchaseOrderSubEntity> {
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
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜索页面-采购订单Tab
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabSearchPurchaseOrderVO> searchTabList(TabSearchDTO tabSearchDTO);
}
