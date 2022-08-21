package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.PurchaseOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.PurchaseOrderSubMapper;
import com.lianchuangjie.lianchuangjie.service.PurchaseOrderSubService;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryPurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquirySalesOrderVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationPurchaseOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PurchaseOrderSubServiceImpl extends ServiceImpl<PurchaseOrderSubMapper, PurchaseOrderSubEntity> implements PurchaseOrderSubService {
    @Resource
    PurchaseOrderSubMapper purchaseOrderSubMapper;

    @Override
    public Page<TabQuotationPurchaseOrderVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        purchaseOrderSubMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    @Override
    public Page<TabEnquiryPurchaseOrderVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryPurchaseOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_OPOR.DocDate"));
        purchaseOrderSubMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }
}
