package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquirySubMapper extends BaseMapper<EnquirySubEntity> {
    List<EnquirySubVO> selectList(@Param("ew") QueryWrapper<EnquirySubVO> queryWrapper);

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
     * @param page         page
     * @param tabSearchDTO tabSearchDTO
     * @return IPage
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    IPage<TabEnquiryNeedsVO> selectEnquiryTabList(Page<TabEnquiryNeedsVO> page, @Param("sc") TabSearchDTO tabSearchDTO);
}
