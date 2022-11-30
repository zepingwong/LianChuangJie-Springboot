package com.lianchuangjie.lianchuangjie.mapper.Quotation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.Quotation.QuotationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuotationMapper extends BaseMapper<QuotationEntity> {
    /**
     * @param page         page
     * @param quotationSearchDTO     quotationSearchDTO
     * @return IPage
     * @description 报价信息列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/21/2022
     */
    IPage<QuotationVO> selectList(IPage<QuotationVO> page, @Param("sc") QuotationSearchDTO quotationSearchDTO);
    /**
     * @param queryWrapper queryWrapper
     * @return QuotationEntity
     * @description 获取一条报价信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/21/2022
     */
    QuotationEntity selectOne(@Param("ew") QueryWrapper<QuotationEntity> queryWrapper);
    Long count(@Param("DocEntry") Long docEntry);
}
