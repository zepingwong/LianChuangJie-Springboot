package com.lianchuangjie.lianchuangjie.mapper.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.CurVat.VatGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VatGroupMapper extends BaseMapper<VatGroupEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 查询税率列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/30/2022
     */
    List<VatGroupVO> selectList(@Param("ew") QueryWrapper<VatGroupVO> queryWrapper);

    /**
     * @param queryWrapper queryWrapper
     * @return VatGroupVO
     * @description 查询单个税率
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/30/2022
     */
    VatGroupVO selectOne(@Param("ew") QueryWrapper<VatGroupVO> queryWrapper);
}
