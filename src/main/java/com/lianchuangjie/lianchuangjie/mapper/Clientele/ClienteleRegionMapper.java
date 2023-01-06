package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleRegionItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleRegionMapper extends BaseMapper<ClienteleRegionEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 获取业务合作伙伴地区
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<ClienteleRegionItemVO> selectList(@Param("ew") QueryWrapper<ClienteleRegionItemVO> queryWrapper);
}
