package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquirySubServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquirySubService {
    @Resource
    EnquirySubMapper enquirySubMapper;

    @Override
    public List<EnquirySubVO> list(Long docEntry) {
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<EnquirySubVO> queryWrapper = new QueryWrapper<>();
        String mainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        String subTable = SqlHelper.table(EnquirySubEntity.class).getTableName();
        queryWrapper.eq(subTable + ".DocEntry", docEntry);
        queryWrapper.eq(mainTable + ".OwnerCode", userSign);
        return enquirySubMapper.selectList(queryWrapper);
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        enquirySubMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        enquirySubMapper.selectEnquiryTabList(page, searchCondition);
        return page;
    }
}
