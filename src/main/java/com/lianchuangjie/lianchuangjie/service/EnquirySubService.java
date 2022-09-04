package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceEnquiryVO;

import java.util.List;

public interface EnquirySubService extends IService<EnquirySubEntity> {
    List<EnquirySubVO> list(Long docEntry);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-销售报价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceEnquiryVO> stockTabList(TabSearchDTO tabSearchDTO);
}
