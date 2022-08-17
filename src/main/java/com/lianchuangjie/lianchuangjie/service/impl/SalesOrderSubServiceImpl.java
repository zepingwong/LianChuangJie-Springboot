package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import com.lianchuangjie.lianchuangjie.mapper.SalesOrderSubMapper;
import com.lianchuangjie.lianchuangjie.service.SalesOrderSubService;
import com.lianchuangjie.lianchuangjie.vo.TabSalesOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesOrderSubServiceImpl extends ServiceImpl<SalesOrderSubMapper, SalesOrderSubEntity> implements SalesOrderSubService {
    @Resource
    SalesOrderSubMapper salesOrderSubMapper;
    @Override
    public Page<TabSalesOrderVO> tabList(TabSearchDTO searchCondition) {
        Page<TabSalesOrderVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        salesOrderSubMapper.selectTabList(page, searchCondition.getModleList(), searchCondition.getUserSign());
        return page;
    }
}
