package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceEnquiryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquirySubMapper extends BaseMapper<EnquirySubEntity> {
    Integer count(@Param("DocEntry") Long docEntry);
    /**
     * @param enquirySubEntity enquirySubEntity
     * @return Boolean
     * @description 更新一条货源，更新的就是原始需求那一条
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    Boolean updateOne(@Param("Entity") EnquirySubEntity enquirySubEntity);

    EnquirySubEntity selectOne(@Param("DocEntry") Long docEntry, @Param("LineNum") Long lineNum);

    /**
     * @param enquirySubSearchDTO enquirySubSearchDTO
     * @return List
     * @description 获取询价单子表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    List<EnquirySubVO> selectList(@Param("sc") EnquirySubSearchDTO enquirySubSearchDTO);

    Boolean clear(@Param("DocEntry") Long docEntry, @Param("LineNum") Long lineNum);

    /**
     * @param page         page
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    IPage<TabQuotationNeedsVO> selectQuotationTabList(IPage<TabQuotationNeedsVO> page, @Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    List<TabEnquiryNeedsVO> selectEnquiryTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param tabSearchDTO tabSearchDTO
     * @return Integer
     * @description 销售报价页面-客户需求TAB计数
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Integer countEnquiryTabList(@Param("sc") TabSearchDTO tabSearchDTO);

    /**
     * @param page            page
     * @param searchCondition searchCondition
     * @return IPage
     * @description 库存定价-销售报价TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    IPage<TabStockPriceEnquiryVO> selectStockPriceTabList(IPage<TabStockPriceEnquiryVO> page, @Param("sc") TabSearchDTO searchCondition);
}
