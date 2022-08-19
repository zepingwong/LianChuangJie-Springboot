package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationSalesOrderVO;

public interface SalesOrderSubService extends IService<SalesOrderSubEntity> {
    Page<TabQuotationSalesOrderVO> quotationTabList(TabSearchDTO tabSearchDTO);
}
