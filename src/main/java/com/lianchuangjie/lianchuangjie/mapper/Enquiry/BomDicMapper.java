package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDictSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomHeadDicEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomHeadDictVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BomDicMapper extends BaseMapper<BomHeadDicEntity> {
    List<String> selectNameList(@Param("ew") QueryWrapper<String> wrapper);

    /**
     * @param page                 page
     * @param bomHeadDictSearchDTO bomHeadDictSearchDTO
     * @return IPage
     * @description 获取字典列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/30/2022
     */
    IPage<BomHeadDictVO> selectList(IPage<BomHeadDictVO> page, @Param("sc") BomHeadDictSearchDTO bomHeadDictSearchDTO);
}
