package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleIndustryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleIndustryMapper extends BaseMapper<ClienteleIndustryEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 查询业务合作伙伴行业
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<ClienteleIndustryVO> selectList(@Param("ew") QueryWrapper<ClienteleIndustryVO> queryWrapper);
}
