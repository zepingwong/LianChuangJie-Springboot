package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleClientLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleLevelItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleClientLevelMapper extends BaseMapper<ClienteleClientLevelEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 客户等级列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<ClienteleLevelItemVO> selectList(@Param("ew") QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
