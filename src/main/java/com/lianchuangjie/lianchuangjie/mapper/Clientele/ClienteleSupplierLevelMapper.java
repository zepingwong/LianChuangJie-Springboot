package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleSupplierLevelEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleLevelItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleSupplierLevelMapper extends BaseMapper<ClienteleSupplierLevelEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 获取供应商等级列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<ClienteleLevelItemVO> selectList(@Param("ew") QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
