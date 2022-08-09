package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleRegionItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClienteleRegionMapper extends BaseMapper<ClienteleRegionEntity> {
    List<ClienteleRegionItemVO> queryByParentCode(Integer ParentCode);
}
