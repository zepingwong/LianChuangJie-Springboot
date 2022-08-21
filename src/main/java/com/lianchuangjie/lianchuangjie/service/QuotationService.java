package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.QuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryQuotationVO;
import com.lianchuangjie.lianchuangjie.vo.TabMyQuotationVO;

public interface QuotationService extends IService<QuotationEntity> {
    Page<QuotationVO> list(QuotationSearchDTO quotationSearchDTO);

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 我的报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabMyQuotationVO> tabMyList(TabSearchDTO searchCondition);

    QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */

    Page<TabEnquiryQuotationVO> enquiryTabList(TabSearchDTO tabSearchDTO);
}
