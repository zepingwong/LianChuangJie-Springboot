package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationSalesOrderVO;

public interface PurchaseOrderSubService extends IService<PurchaseOrderSubEntity> {
    Page<TabQuotationPurchaseOrderVO> quotationTabList(TabSearchDTO tabSearchDTO);
}
