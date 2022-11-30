package com.lianchuangjie.lianchuangjie.mapper.CurVat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.dto.CurVat.CurVatSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurVatConfEntity;
import com.lianchuangjie.lianchuangjie.vo.CurVat.CurVatConfVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CurVatConfMapper extends BaseMapper<CurVatConfEntity> {
    /**
     * @param curVatSearchDTO curVatSearchDTO
     * @return List
     * @description 查询货币税率配置列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/30/2022
     */
    List<CurVatConfVO> selectList(@Param("sc") CurVatSearchDTO curVatSearchDTO);

    /**
     * @param queryWrapper queryWrapper
     * @return CurVatConfVO
     * @description 获取一条货币税率配置
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/30/2022
     */
    CurVatConfVO selectOne(@Param("ew") QueryWrapper<CurVatConfVO> queryWrapper);
}
