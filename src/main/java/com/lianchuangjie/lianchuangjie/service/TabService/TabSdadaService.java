package com.lianchuangjie.lianchuangjie.service.TabService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankSdadaVO;

public interface TabSdadaService extends IService<SdadaEntity> {
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 采购报价-标准型号TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabQuotationSdadaVO> quotationTabList(TabSearchDTO tabSearchDTO);
    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 库存排名-标准型号TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Page<TabStockRankSdadaVO> stockRankTabList(TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Page
     * @description 模糊搜索-标准型号-多个型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<TabSearchSdadaVO> searchTabList(TabSearchDTO tabSearchDTO);
}
