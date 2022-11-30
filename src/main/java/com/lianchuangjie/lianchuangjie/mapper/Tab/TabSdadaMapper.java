package com.lianchuangjie.lianchuangjie.mapper.Tab;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.TabStockRankSdadaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabSdadaMapper extends BaseMapper<SdadaEntity> {
    /**
     * @param page page
     * @param list list
     * @return IPage
     * @description 采购报价-标准型号TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabQuotationSdadaVO> selectQuotationSdadaTab(IPage<TabQuotationSdadaVO> page, @Param("modleList") List<String> list);

    /**
     * @param page page
     * @param list list
     * @return IPage
     * @description 库存排名-标准型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<TabStockRankSdadaVO> selectStockRankSdadaTab(IPage<TabStockRankSdadaVO> page, @Param("modleList") List<String> list);

    /**
     * @param page      page
     * @param modleList modleList
     * @return IPage
     * @description 模糊搜索-标准型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */

    IPage<TabSearchSdadaVO> selectSearchTabList(Page<TabSearchSdadaVO> page, @Param("modleList") List<String> modleList);
}
