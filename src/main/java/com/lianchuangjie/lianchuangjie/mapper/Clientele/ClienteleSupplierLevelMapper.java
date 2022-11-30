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
    List<ClienteleLevelItemVO> selectList(@Param("ew") QueryWrapper<ClienteleLevelItemVO> queryWrapper);
}
