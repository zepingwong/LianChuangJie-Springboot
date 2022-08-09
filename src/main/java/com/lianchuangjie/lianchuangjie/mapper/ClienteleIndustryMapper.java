package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleIndustryEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleIndustryItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClienteleIndustryMapper extends BaseMapper<ClienteleIndustryEntity> {
    List<ClienteleIndustryItemVO> queryByParentCode(String ParentCode);
}
