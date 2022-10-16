package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.*;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;

import java.util.List;

public interface EnquirySubService extends IService<EnquirySubEntity> {
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 获取询价单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    Page<EnquirySubVO> list(EnquirySubSearchDTO searchCondition);
    Boolean save(List<EnquirySaveItemDTO> list);

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
     * @description 模糊搜索页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    Page<TabSearchNeedsVO> searchTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存定价页面-销售报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    Page<TabStockPriceEnquiryVO> stockTabList(TabSearchDTO tabSearchDTO);

    Boolean saveOne(EnquirySaveItemDTO enquirySaveItemDTO);
}
