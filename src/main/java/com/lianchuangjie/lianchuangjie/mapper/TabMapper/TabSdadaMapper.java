package com.lianchuangjie.lianchuangjie.mapper.TabMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationSdadaVO;
import com.lianchuangjie.lianchuangjie.vo.Search.TabSearchSdadaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TabSdadaMapper extends BaseMapper<SdadaEntity> {
    IPage<TabQuotationSdadaVO> selectQuotationSdadaTab(IPage<TabQuotationSdadaVO> page, @Param("modleList") List<String> list);

    IPage<TabSearchSdadaVO> selectSearchTabList(Page<TabSearchSdadaVO> page, @Param("modleList")  List<String> modleList);
}
