package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.SalesOrderSubMapper;
import com.lianchuangjie.lianchuangjie.service.SalesOrderSubService;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationSalesOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesOrderSubServiceImpl extends ServiceImpl<SalesOrderSubMapper, SalesOrderSubEntity> implements SalesOrderSubService {
    @Resource
    SalesOrderSubMapper salesOrderSubMapper;
    public Page<TabQuotationSalesOrderVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        salesOrderSubMapper.selectTabList(page, searchCondition);
        return page;
    }
}
