package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.QuotationReplyDTO;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.*;
import com.lianchuangjie.lianchuangjie.vo.Quotation.QuotationVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabMyQuotationVO;

public interface QuotationService extends IService<QuotationEntity> {
    /**
     * @param quotationReplyDTO quotationReplyDTO
     * @return Boolean
     * @description 采购回复
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    Boolean reply(QuotationReplyDTO quotationReplyDTO);

    /**
     * @param queryWrapper queryWrapper
     * @return QuotationEntity
     * @description 查询一条采购报价信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper);

    Page<QuotationVO> getList(QuotationSearchDTO quotationSearchDTO);

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 我的报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabMyQuotationVO> tabMyList(TabSearchDTO searchCondition);

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 有效报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabEffectiveQuotationVO> tabEffectiveList(TabSearchDTO searchCondition);


    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabEnquiryQuotationVO> enquiryTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜索-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabSearchQuotationVO> searchTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价-采购报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceQuoteVO> stockTabList(TabSearchDTO tabSearchDTO);
}
